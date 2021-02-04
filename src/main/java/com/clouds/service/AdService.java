package com.clouds.service;

import com.clouds.bean.His;
import com.clouds.dto.AdDto;

import java.util.List;

public interface AdService {
    /***
     * 根据条件查询信息
     * @param adDto 查询条件
     * @return List<AdDto>
     */
    public List<AdDto> searchByPage(AdDto adDto);
    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteI(int id);

}
