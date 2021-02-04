package com.clouds.service;

import com.clouds.bean.His;
import com.clouds.dto.HisDto;

import java.util.List;

public interface HisService {
    /***
     * 根据条件查询信息
     * @param HisDto 查询条件
     * @return List<AdDto>
     */
    public List<HisDto> searchByPage(HisDto hisDto);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteI(int id);

}
