package com.yu.arksys.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/accounts")
    public ModelAndView accounts() {
        return new ModelAndView("accounts");
    }

    @RequestMapping("/main")
    public ModelAndView index() {
        return new ModelAndView("main");
    }


}
