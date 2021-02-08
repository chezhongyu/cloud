<%@tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="page" type="com.clouds.util.Page" required="true" %>
<%@attribute name="jsMethodName" type="java.lang.String" required="true" %>

<script>
    function tranCurrentPage(currentPage){
        var rule = /^[0-9]*[1-9][0-9]*$/
        if(!rule.test(currentPage)){
            currentPage = 1;
        }
        //解析并调用js中的方法
        <%--<t:page jsMethodName="search"> </t:page>--%>
        eval("${jsMethodName}(currentPage)");

    }


</script>

<div class="page fix">
    <a href="javascript:tranCurrentPage('1')" class="first">首页</a>
    <a href="javascript:tranCurrentPage('${page.currentPage-1}')" class="pre">上一页</a>
    当前第<span>${page.currentPage}/${page.totalPage}</span>页
    <a href="javascript:tranCurrentPage('${page.currentPage+1}')" class="next">下一页</a>
    <a href="javascript:tranCurrentPage('${page.totalPage}')" class="last">末页</a>
    跳转&nbsp;<input type="text" id="currentPageText" class="allInput w28" value="1">&nbsp;页
    <a href="javascript:tranCurrentPage($('#currentPageText').val())" class="go">GO</a>

</div>