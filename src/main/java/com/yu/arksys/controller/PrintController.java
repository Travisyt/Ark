package com.yu.arksys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintController {


    @RequestMapping("/printPage")
    public ModelAndView printPage() {
        return new ModelAndView("printPage");
    }

}
