package com.clouds.dao;


import com.clouds.bean.His;

import java.util.List;

public interface AdDao {

    /**
     * 根据条件查询
     * 返回list
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
}
