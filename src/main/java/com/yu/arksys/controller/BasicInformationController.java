package com.yu.arksys.controller;

import com.yu.arksys.exception.IncompleteParamException;
import com.yu.arksys.grasp.service.BusinessRelatedUnitService;
import com.yu.arksys.grasp.service.CommodityService;
import com.yu.arksys.utils.CollectUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
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
            map.put("data", businessRelatedUnitService.getBusinessAddress(btypeid));
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
        System.out.println("=======================数据请求======================");
        System.out.println("/basicInfo/getCommodityUnitMap parameters:");
        System.out.println("parid: " + ParId);
        System.out.println("=======================请求结束======================");
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

}