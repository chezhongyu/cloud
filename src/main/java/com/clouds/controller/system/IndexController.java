package com.clouds.controller.system;

import com.clouds.dto.HisDto;
import com.clouds.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/his")
public class IndexController {
    @Autowired
    private HisService hisService;
    @RequestMapping
    public String init(ModelMap modelMap){
        HisDto hisDto = new HisDto();
        modelMap.addAttribute("list", hisService.searchByPage(hisDto));
        return "/system/user-list";
    }

//    @RequestMapping
//    public String init(){
//        return "/system/add-list";
//    }
}
