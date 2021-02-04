package com.clouds.controller.content;

import com.clouds.dto.HisDto;
import com.clouds.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by foreknow on 2021/1/25
 */
@Controller
@RequestMapping("/his")
public class AdController {
    @Autowired
    private HisService hisService;
    @RequestMapping
    public String init(ModelMap modelMap){
        HisDto hisDto = new HisDto();
        modelMap.addAttribute("list", hisService.searchByPage(hisDto));
        return "/system/user-list";
    }

    @RequestMapping("/search")
    public String search(ModelMap modelMap,HisDto adDto){
        modelMap.addAttribute("list", hisService.searchByPage(adDto));
        //jsp页面中的分页标签使用Page类型，所以可以通过hisDto关联到Page对象
        modelMap.addAttribute("searchParam",adDto);
        return "/system/user-list";

    }

    @RequestMapping("/delete/{id}")
    public String delete(@ModelAttribute("id") Integer id){
        hisService.deleteI(id);
        return "/system/user-list";
    }


}
