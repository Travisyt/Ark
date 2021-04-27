package com.yu.arksys.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/fortemp")
    public ModelAndView fortemp() {
        return new ModelAndView("fortemp");
    }

    @RequestMapping("/qiuhun")
    public ModelAndView qiuhun() {
        return new ModelAndView("qiuhun");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/accounts")
    public ModelAndView accounts() {
        return new ModelAndView("accounts");
    }

    @RequestMapping("/main")
    public ModelAndView index(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "content", required = false) String content) {
        System.out.println("====================== 请求 ======================");
        System.out.println("page: " + page + ";    " + "content: " + content);
        String page_ = "dataView", content_ = "dataView";
        if (page != null && !page.equals("") && content != null && !content.equals("")) {
            page_ = page;
            content_ = content;
        }
        return new ModelAndView("main").addObject("page", page_).addObject("content", content_);
    }

    @RequestMapping("/dataView")
    public ModelAndView dataView() {
        return new ModelAndView("dataview");
    }

    @RequestMapping("/goodsSelect")
    public ModelAndView goodsSelect() {
        return new ModelAndView("goodsSelect");
    }

    @RequestMapping("/orderDrafts")
    public ModelAndView orderDrafts() {
        return new ModelAndView("OrderDrafts");
    }

    @RequestMapping("/currentWork")
    public ModelAndView currentWork() {
        return new ModelAndView("currentWork");
    }

    @RequestMapping("/businessMap")
    public ModelAndView businessMap() {
        return new ModelAndView("businessMap");
    }

    @RequestMapping("/businessMapForm")
    public ModelAndView businessMapForm() {
        return new ModelAndView("businessMapForm");
    }

    @RequestMapping("/stockAlerts")
    public ModelAndView stockAlerts() {
        return new ModelAndView("stockAlerts");
    }

}
