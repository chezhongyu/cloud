package com.clouds.service;

import com.clouds.bean.His;
import com.clouds.dto.HisDto;

import java.util.List;

public interface HisService {
    /**
     * username模糊查询
     * @param hisDto
     * @return
     */
    public List<HisDto> searchByPage(HisDto hisDto);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteI(int id);


    /**
     * 添加
     * @param hisDto
     * @return
     */
    public boolean insertI(HisDto hisDto);


    /**
     * 根据id查询
     * @param hisDto
     * @return
     */
    public His selectOne(HisDto hisDto);


    /**
     * 修改
     * @param hisDto
     * @return
     */
    public boolean updateI(HisDto hisDto);




}
