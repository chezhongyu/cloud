package com.clouds.service.Impl;

import com.clouds.bean.His;
import com.clouds.dao.HisDao;
import com.clouds.dto.HisDto;
import com.clouds.service.HisService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HisServiceImpl implements HisService {
    @Autowired
    private HisDao hisDao;

    @Value("$(adImage.savePath)")
    private String adImageSavePath;

    @Override
    public List<HisDto> searchByPage(HisDto hisDto) {
        List<HisDto> result = new ArrayList<>();
        His condition = new His();
        BeanUtils.copyProperties(hisDto,condition);
        List<His> hisList = hisDao.selectByPage(condition);
        for (His his:hisList) {
            HisDto hisDtoTemo = new HisDto();
            BeanUtils.copyProperties(his,hisDtoTemo);
            result.add(hisDtoTemo);
        }
        return result;

    }


    @Override
    public boolean deleteI(int id) {
        hisDao.delete(id);
        return true;
    }

}
