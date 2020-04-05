package com.yu.arksys.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.yu.arksys.bean.AccountsRecord;
import com.yu.arksys.bean.OrderRecord;
import com.yu.arksys.grasp.service.ActionLogService;
import com.yu.arksys.service.api.MappingService;
import com.yu.arksys.service.api.accounts.AccountsService;
import com.yu.arksys.service.api.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataController {

    public static final Integer DEFAULT_PAGE_SIZE = 20;

    @Autowired
    MappingService mappingService;

    @Autowired
    OrderService orderService;

    @Autowired
    AccountsService accountsService;

    @RequestMapping("/fullyMapping")
    @ResponseBody
    public Map<String, Object> getFullyMapping() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", mappingService.getFullyMapping());
        map.put("status", "200");
        return map;
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    public List<OrderRecord> getOrders(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return orderService.getOrders(pageSize, pageNum);
    }

    @RequestMapping("/accountsData")
    @ResponseBody
    public Map<String, Object> getAccounts(Integer pageSize, Integer pageNum, String orderBy, String conditions) {
        Map<String, Object> map;
        System.out.println("=============================================");
        System.out.println("/accountsData parameters:");
        System.out.println("pageSize: " + pageSize);
        System.out.println("pageNum: " + pageNum);
        System.out.println("orderBy: " + orderBy);
        System.out.println("conditions: " + conditions);
        System.out.println("=============================================");
        if (conditions != null && !conditions.equals("{}")) {
            Map conditonsMap = (Map<String, String>)JSON.parseObject(conditions, Map.class);
            if (orderBy != null && !orderBy.equals("")) {
                map = accountsService.getData(pageSize, pageNum, orderBy, conditonsMap);
            } else {
                map = accountsService.getData(pageSize, pageNum, conditonsMap);
            }
        } else {
            if (orderBy != null && !orderBy.equals("")) {
                map = accountsService.getData(pageSize, pageNum, orderBy);
            } else {
                map = accountsService.getData(pageSize, pageNum);
            }
        }
        map.put("status", "200");
        return map;
    }

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping("/actionWatchInfos")
    @ResponseBody
    public Map<String, Object> actionWatchInfos(Integer pageSize, Integer pageNum, String orderBy, String conditions) {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> parsedConditions = new HashMap<>();
        if (conditions != null && !conditions.equals("{}")) {
            parsedConditions = JSON.parseObject(conditions, Map.class);
        }
        System.out.println("=============================================");
        System.out.println("/actionWatchInfos parameters:");
        System.out.println("pageSize: " + pageSize);
        System.out.println("pageNum: " + pageNum);
        System.out.println("orderBy: " + orderBy);
        System.out.println("conditions: " + parsedConditions);
        System.out.println("=============================================");
        try {
            map.put("data", actionLogService.getEmployeeAction(
                    pageSize==null?DEFAULT_PAGE_SIZE:pageSize,
                    pageNum==null?1:pageNum,
                    orderBy, parsedConditions));
            map.put("totalDataNum", actionLogService.getActionCount(parsedConditions));
            map.put("status", "200");
        } catch (Exception e) {
            map.put("status", "404");
            e.printStackTrace();
        }
        return map;
    }


}
