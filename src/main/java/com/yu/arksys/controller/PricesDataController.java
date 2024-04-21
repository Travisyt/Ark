package com.yu.arksys.controller;

import com.yu.arksys.grasp.service.prices.PricesService;
import com.yu.arksys.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pricesData")
public class PricesDataController {

    @Autowired
    PricesService pricesService;

    @ResponseBody
    @RequestMapping("/getCommoditySalesAtPriceOneMonth")
    public Map<String, Object> getCommoditySalesAtPriceOneMonth(String ptypeid, String yearMonth){
        Map<String, String> params = new HashMap<>();
        params.put("getCommoditySalesAtPriceOneMonth: ptypeid", ptypeid);
        params.put("getCommoditySalesAtPriceOneMonth: month", yearMonth);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", pricesService.getSalesAtPrices(ptypeid, yearMonth));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/getCommoditySalesAtPriceAll")
    public Map<String, Object> getCommoditySalesAtPriceAll(String ptypeid){
        Map<String, String> params = new HashMap<>();
        params.put("getCommoditySalesAtPriceAll: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", pricesService.getSalesAtPrices(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/getCommoditySalesAtPriceLastThreeMonth")
    public Map<String, Object> getCommoditySalesAtPriceLastThreeMonth(String ptypeid){
        Map<String, String> params = new HashMap<>();
        params.put("getCommoditySalesAtPriceLastThreeMonth: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", pricesService.getSalesAtPricesLastThreeMonth(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }
}
