package com.yu.arksys.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView index(HttpServletRequest request) {
        String page = request.getParameter("page");
        String content = request.getParameter("content");
        String page_ = "accounts";
        String content_ = "general-accounts";
        if (page != null && !page.equals("") && content != null && !content.equals("")) {
            page_ = page;
            content_ = content;
        }
        ModelAndView modelAndView =  new ModelAndView("main");
        modelAndView.addObject("page", page_);
        modelAndView.addObject("content", content_);
        return modelAndView;
    }


}
