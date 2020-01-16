package com.yu.arksys.controller;

import com.yu.arksys.service.api.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    MappingService mappingService;

    /**
     * 测试后台数据是否正确
     * @return json
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, List<Map<String, String>>> test() {
        System.out.println(mappingService.getFullyMapping());
        return mappingService.getFullyMapping();
    }

    @RequestMapping("/order")
    public ModelAndView order() {
        return new ModelAndView("main");
    }


}
