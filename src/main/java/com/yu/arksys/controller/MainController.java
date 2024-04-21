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
        return new ModelAndView("baidutest");
    }

    /**
     * 费用核算主页
     */
    @RequestMapping("/costIndex")
    public ModelAndView costIndex(){
        return new ModelAndView("costIndex");
    }

    /**
     * 定价系统主页
     */
    @RequestMapping("/priceIndex")
    public ModelAndView priceIndex(){
        return new ModelAndView("priceIndex");
    }

    /**
     * 万能数据
     * @return 万能数据页面
     */
    @RequestMapping("/universalData")
    public ModelAndView universalData() {
        return new ModelAndView("universalData");
    }

    @RequestMapping("/stockWatch")
    public ModelAndView stockWatch() {
        return new ModelAndView("stockWatch");
    }


    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    /**
     * 旧记账系统
     * @return 旧记账系统页面
     */
    @RequestMapping("/accounts")
    public ModelAndView accounts() {
        return new ModelAndView("accounts");
    }

    /**
     * 主页面
     * @param page 嵌入式页面
     * @param content 内容
     * @return 主页面
     */
    @RequestMapping("/main")
    public ModelAndView index(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "content", required = false) String content) {
        System.out.println("请  求: page: " + page + ";    " + "content: " + content);
        System.out.println("page: " + page + ";    " + "content: " + content);
        String page_ = "dataView", content_ = "dataView";
        if (page != null && !page.equals("") && content != null && !content.equals("")) {
            page_ = page;
            content_ = content;
        }
        return new ModelAndView("main").addObject("page", page_).addObject("content", content_);
    }

    /**
     * 月销售数据
     * @return 月销售数据视图
     */
    @RequestMapping("/dataView")
    public ModelAndView dataView() {
        return new ModelAndView("dataview");
    }

    /**
     * 商品选择（模态框）
     * @return 商品选择视图
     */
    @RequestMapping("/goodsSelect")
    public ModelAndView goodsSelect() {
        return new ModelAndView("goodsSelect");
    }

    /**
     * 草稿订单
     * @return 草稿订单视图
     */
    @RequestMapping("/orderDrafts")
    public ModelAndView orderDrafts() {
        return new ModelAndView("OrderDrafts");
    }

    /**
     * 客户单位地图
     * @return 客户单位地图视图
     */
    @RequestMapping("/businessMap")
    public ModelAndView businessMap() {
        return new ModelAndView("businessMap");
    }

    /**
     * 客户单位地图
     * @return 客户单位地图视图
     */
    @RequestMapping("/businessMapForm")
    public ModelAndView businessMapForm() {
        return new ModelAndView("businessMapForm");
    }

    /**
     * 库存报警
     * @return 库存报警视图
     */
    @RequestMapping("/stockAlerts")
    public ModelAndView stockAlerts() {
        return new ModelAndView("stockAlerts");
    }


    @RequestMapping("/everydayShow")
    public ModelAndView everydayShow(){
        return new ModelAndView("everydayShow");
    }

}
