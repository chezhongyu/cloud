package com.clouds.controller.content;

import com.clouds.constant.PageCodeEnum;
import com.clouds.dao.AdDao;
import com.clouds.dto.AdDto;
import com.clouds.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * create by foreknow on 2021/1/25
 */
@Controller
@RequestMapping("/his")
public class AdController {
    @Autowired
    private AdService adService;
    @RequestMapping
    public String init(ModelMap modelMap){
        AdDto adDto = new AdDto();
        modelMap.addAttribute("list",adService.searchByPage(adDto));
        return "/system/user-list";
    }

    @RequestMapping("/search")
    public String search(ModelMap modelMap,AdDto adDto){
        modelMap.addAttribute("list",adService.searchByPage(adDto));
        //jsp页面中的分页标签使用Page类型，所以可以通过adDto关联到Page对象
        modelMap.addAttribute("searchParam",adDto);
        return "/system/user-list";

    }

    @RequestMapping("/delete/{id}")
    public String delete(@ModelAttribute("id") Integer id){
        adService.deleteI(id);
        return "/system/user-list";
    }


}
