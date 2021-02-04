package com.clouds.dao.interceptor;

import com.clouds.bean.BaseBean;
import com.clouds.util.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 创建一个自定义的拦截器（原理是基于动态代理来实现的）
 * @Intercepts表示当前定义的类是一个自定义的拦截器
 * {@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})}
 * 说明：表示我们要拦截StatementHandler对象中的prepare方法， args:方法参数的类型
 *
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class PageInterceptor implements Interceptor{

    /**
     * 核心拦截器的方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //1.获取到目标对象
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //2.获取到元数据对象，之后我们就可以从这个对象(MetaObject)中的方法获取到我们要处理的拦截操作
        MetaObject metaObject = MetaObject.forObject(statementHandler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        //根据key来获取到映射对象MappedStatement----------AdDao.xml
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //然后可以获取到操作的id
        String id = mappedStatement.getId();
        if(id.endsWith("ByPage")) {
            //我们要获取到拦截操作的SQL语句
            BoundSql boundSql = statementHandler.getBoundSql();
            //获取到AdDao.xml中的SQL语句
            String sql = boundSql.getSql();
            //计算总的记录数
            String countsql = "select count(*) from("+sql+")t";
            //获取到prepare（Connection con） Connection接口
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = connection.prepareStatement(countsql);
            //通过元数据获取到ParameterHandler对象，目的就是将?替换成具体的值
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(preparedStatement);
            //执行查询
            ResultSet rs = preparedStatement.executeQuery();
            //可以通过BoundSql方法来获取到分页的BaseBean对象
            BaseBean bean = (BaseBean) boundSql.getParameterObject();
            Page page = bean.getPage();
            if(rs.next()) {
                //将总的记录数获取到并赋值给Page对象中的totalNumber属性
                page.setTotalNumber(rs.getInt(1));
            }
            //完成分页  select * from table limit (currentPage-1)*pageSize,pageSize
            //select id,title,img_file_name,link,weight from ad limit(m,n)
            String pageSql = sql+" limit "+(page.getCurrentPage()-1)*page.getPageNumber()+","+page.getPageNumber();
            //重写分页的sql
            metaObject.setValue("delegate.boundSql.sql",pageSql);
        }
        //将执行权交给下一个拦截器，如果没有的话再将资源交给Controller
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}