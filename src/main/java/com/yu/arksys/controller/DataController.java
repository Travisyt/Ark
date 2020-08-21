package com.yu.arksys.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.yu.arksys.bean.AccountsRecord;
import com.yu.arksys.bean.OrderRecord;
import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.dao.CommodityUnitDao;
import com.yu.arksys.grasp.dao.StockDao;
import com.yu.arksys.grasp.service.ActionLogService;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.CommodityService;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import com.yu.arksys.service.api.MappingService;
import com.yu.arksys.service.api.accounts.AccountsService;
import com.yu.arksys.service.api.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println("=======================数据请求======================");
        System.out.println("/accountsData parameters:");
        System.out.println("pageSize: " + pageSize);
        System.out.println("pageNum: " + pageNum);
        System.out.println("orderBy: " + orderBy);
        System.out.println("conditions: " + conditions);
        if (conditions != null && !conditions.equals("{}")) {
            Map conditonsMap = (Map<String, String>) JSON.parseObject(conditions, Map.class);
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
        System.out.println("=======================请求结束======================");
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
        System.out.println("=======================数据请求======================");
        System.out.println("/actionWatchInfos parameters:");
        System.out.println("pageSize: " + pageSize);
        System.out.println("pageNum: " + pageNum);
        System.out.println("orderBy: " + orderBy);
        System.out.println("conditions: " + parsedConditions);
        try {
            map.put("data", actionLogService.getEmployeeAction(
                    pageSize == null ? DEFAULT_PAGE_SIZE : pageSize,
                    pageNum == null ? 1 : pageNum,
                    orderBy, parsedConditions));
            map.put("totalDataNum", actionLogService.getActionCount(parsedConditions));
            map.put("status", "200");
        } catch (Exception e) {
            map.put("status", "404");
            e.printStackTrace();
        }
        System.out.println("=======================请求结束======================");
        return map;
    }

    @Autowired
    DetailedBillDraftService detailedBillDraftService;

    @RequestMapping("/getPersonalCurrentSaleDraft")
    @ResponseBody
    public Map<String, Object> getPersonalCurrentSaleDraft(String etypeid) {
        System.out.println("=======================数据请求======================");
        System.out.println("/getPersonalCurrentSaleDraft parameters:");
        System.out.println("etypeid: " + etypeid);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", detailedBillDraftService.getCurrentSaleDraftWithEmployee(etypeid));
            res.put("status", "200");
        } catch (Exception e) {
            res.put("status", "302");
            e.printStackTrace();
        }
        System.out.println("=======================请求结束======================");
        return res;
    }

    @Autowired
    BeanMappingService beanMappingService;

    @RequestMapping("/getEmployeeMap")
    @ResponseBody
    public Map<String, Object> getEmployeeMap() {
        System.out.println("=======================数据请求======================");
        System.out.println("/getEmployeeMap parameters: none");
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", beanMappingService.getEmployeeMap());
            res.put("status", "200");
        } catch (Exception e) {
            res.put("status", "302");
            e.printStackTrace();
        }
        System.out.println("=======================请求结束======================");
        return res;
    }

    @RequestMapping("/getBtypeMap")
    @ResponseBody
    public Map<String, Object> getBtypeMap(String etypeid) {
        System.out.println("=======================数据请求======================");
        System.out.println("/getBtypeMap parameters:");
        System.out.println("etypeid: " + etypeid);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", detailedBillDraftService.getCurrentBtypeMap(etypeid));
            res.put("status", "200");
        } catch (Exception e) {
            res.put("status", "302");
            e.printStackTrace();
        }
        System.out.println("=======================请求结束======================");
        return res;
    }

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/getPtypeInfos")
    @ResponseBody
    public Map<String, String> getPtypeName(String pusercode) {
        System.out.println("=======================数据请求======================");
        System.out.println("/getPtypeNameByCode parameters:");
        System.out.println("pusercode: " + pusercode);
        System.out.println("=======================请求结束======================");
        Map<String, String> map = new HashMap<>();
        map.put("name", commodityDao.findFullNameByCode(pusercode).get(0));
        map.put("firstPrice", commodityService.getFirstPriceByPusercode(pusercode));
        map.put("secondPrice", commodityService.getSecondPriceByPusercode(pusercode));
        map.put("lastPurchasePrice", commodityService.getLastPurchasePriceByPusercode(pusercode));
        return map;
    }

    @Autowired
    CommodityUnitDao commodityUnitDao;

    @RequestMapping("/getCommodityUnitMap")
    @ResponseBody
    public Map<String, Object> getCommodityUnitMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", commodityService.getMergedUnitMap());
        result.put("status", "200");
//        result.put("data", commodityUnitDao.getAllRawCommodityUnits());
        return result;
    }

}
