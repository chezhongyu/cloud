package com.clouds.dao;


import com.clouds.bean.His;

import java.util.List;

public interface HisDao {

    /**
     * username模糊查询
     * @param his
     * @return
     */
    public List<His> selectByPage(His his);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(int id);


    /**
     * 添加
     * @param his
     * @return
     */
    public boolean insert(His his);

    /**
     * 根据id查询
     * @param his
     * @return
     */
    public His selectone(His his);

    /**
     * 修改
     * @param his
     * @return
     */
    public boolean update(His his);
}
