package com.clouds.service.Impl;

import com.clouds.bean.His;
import com.clouds.dao.AdDao;
import com.clouds.dto.AdDto;
import com.clouds.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Value("$(adImage.savePath)")
    private String adImageSavePath;

    @Override
    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result = new ArrayList<>();
        His condition = new His();
        //要将AdDto对象中的所有属性copy到Ad对象中
        BeanUtils.copyProperties(adDto,condition);
        //调用dao方法
        List<His> adList = adDao.selectByPage(condition);
        //要将List<Ad>转化为List<AdDto>
        for (His ad:adList) {
            AdDto adDtoTemo = new AdDto();
            BeanUtils.copyProperties(ad,adDtoTemo);
            result.add(adDtoTemo);
        }
        return result;

    }


    @Override
    public boolean deleteI(int id) {
        adDao.delete(id);
        return true;
    }

}
