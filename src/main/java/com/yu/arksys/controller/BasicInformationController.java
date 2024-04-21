package com.yu.arksys.controller;

import com.yu.arksys.exception.IncompleteParamException;
import com.yu.arksys.grasp.service.customer.BusinessRelatedUnitService;
import com.yu.arksys.grasp.service.commodity.CommodityService;
import com.yu.arksys.utils.CollectUtills;
import com.yu.arksys.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/basicInfo")
public class BasicInformationController {

    @Autowired
    BusinessRelatedUnitService businessRelatedUnitService;

    /**
     *
     * @param btypeid 单位编号
     * @return 返回单位地址信息列表，如果错误，返回
     */
    @RequestMapping("/getBusinessAddress")
    @ResponseBody
    public Map<String, Object> getBusinessAddress(String btypeid){
        Map<String, Object> map = new HashMap<>();
        try {
            if(btypeid == null){
                map.put("data", businessRelatedUnitService.getBusinessAddress());
            } else {
                map.put("data", businessRelatedUnitService.getBusinessAddress(btypeid));
            }
            Map<String, String> logMap = new HashMap<>();
            logMap.put("/basicInfo/getBusinessAddress", "btypeid="+btypeid);
            LogUtils.dataAccessLog(logMap);
            return CollectUtills.putSuccessStatus(map);
        } catch (IncompleteParamException e) {
            return CollectUtills.putFailStatus(map, e.getMessage());
        }
    }

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/getCommodityUnitMap")
    @ResponseBody
    public Map<String, Object> getCommodityUnitMap(String ParId) {
        Map<String, String> logMap = new HashMap<>();
        logMap.put("/basicInfo/getCommodityUnitMap", "ParId="+ParId);
        LogUtils.dataAccessLog(logMap);
        Map<String, Object> result = new HashMap<>();
        if (ParId == null || ParId.equals("")) {
            result.put("data", commodityService.getMergedUnitMap());
            result.put("status", "200");
        } else {
            result.put("data", commodityService.getMergedUnitMapByParId(ParId));
            result.put("status", "200");
        }
        return result;
    }

    @RequestMapping("/getSingleCommodityUnitMap")
    @ResponseBody
    public Map<String, Object> getSingleCommodityUnitMap(String ptypeid) {
        Map<String, String> logMap = new HashMap<>();
        logMap.put("/basicInfo/getSingleCommodityUnitMap", "ptypeid="+ptypeid);
        LogUtils.dataAccessLog(logMap);
        Map<String, Object> result = new HashMap<>();
        if (ptypeid == null || ptypeid.equals("")) {
            result.put("data", commodityService.getMergedUnitMap());
            result.put("status", "200");
        } else {
            result.put("data", commodityService.getMergedUnitMapById(ptypeid));
            result.put("status", "200");
        }
        return result;
    }

}
