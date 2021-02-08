package com.clouds.controller.content;

import com.clouds.dto.HisDto;
import com.clouds.service.HisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/his")
public class AdController {
    @Autowired
    private HisService hisService;
    @RequestMapping("/search")
    public String search(ModelMap modelMap,HisDto hisDto){
        modelMap.addAttribute("list", hisService.searchByPage(hisDto));
        return "/system/user-list";

    }

    @RequestMapping("/delete/{ID}")
    public String delete(@ModelAttribute("ID") Integer id){
        hisService.deleteI(id);
        return "/system/user-list";
    }

    @RequestMapping("/startinsert")
    public String startinsert(){
    return "/system/add-list";
    }

    @RequestMapping("/insert")
    public String insert(HisDto hisDto){
        hisService.insertI(hisDto);
        return "/system/user-list";
    }

    @RequestMapping("/startupdate/{ID}")
    public String startupdate(@ModelAttribute("ID") Integer id,HisDto hisDto,ModelMap modelMap){
        hisDto.setID(id);
        modelMap.addAttribute("one",hisService.selectOne(hisDto));
        return "/system/update-list";
    }


    @RequestMapping("/update")
    public String update(ModelMap modelMap,HisDto hisDto){
        hisService.updateI(hisDto);
        return "/system/user-list";
    }




}
