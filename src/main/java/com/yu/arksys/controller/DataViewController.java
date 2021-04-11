package com.yu.arksys.controller;

import com.yu.arksys.grasp.service.DataViewService;
import com.yu.arksys.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dataview")
public class DataViewController {

    @Autowired
    DataViewService dataViewService;

    /**
     * 每月销售数据
     * @param ptypeid 商品编号
     * @return 每月数据
     */
    @RequestMapping("/getSalesDataPermonth")
    @ResponseBody
    public Map<String, Object> getSalesDataPermonth(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", dataViewService.getSalesDataPermonth(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

}
