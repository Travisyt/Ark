package com.yu.arksys.controller;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.raw.Commodity;
import com.yu.arksys.bean.raw.CommodityBrief;
import com.yu.arksys.bean.response.CommodityBriefWithSalePricesResponse;
import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/commodity")
@Controller
public class CommodityInfoController {

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    CommodityService commodityService;

    /**
     * 模糊查找
     * 调用说明： partName不能包含SQL特殊字符
     * @return Commodity List
     */
    @RequestMapping("getBriefCommodityListByPartName")
    @ResponseBody
    public Map<String, Object> getBriefCommodityListByPartName(String partName, String ktypeid, String orderBy) {
        Map<String, Object> res = new HashMap<>();
        List<CommodityBrief> commodityBriefs = commodityService.getFuzzySearchCommodityListByPartName(partName, ktypeid, orderBy);
        if (commodityBriefs != null) {
            res.put("data", commodityBriefs);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 商品基本信息
     * @param pusercode 商品编码
     * @return Commodity
     */
    @RequestMapping("/getCommodityByCode")
    @ResponseBody
    public Map<String, Object> getCommodityByCode(String pusercode) {
        Commodity commodity = commodityDao.getCommodityByUserId(pusercode);
        Map<String, Object> res = new HashMap<>();
        if (commodity != null) {
            res.put("data", commodity);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    @RequestMapping("/getTotalNum")
    @ResponseBody
    public Map<String, Object> getTotalNum(String ptypeid, String ktypeid) {
        String num;
        if (ktypeid == null || ktypeid.equals("") || ktypeid.equals("00000")) {
            num = commodityDao.getTotalNumByIdMain(ptypeid);
        } else {
            num = commodityDao.getTotalNumById(ptypeid, ktypeid);
        }
        Map<String, Object> res = new HashMap<>();
        if (num != null) {
            res.put("data", num);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    // =============== 商品列表 =============== //

    /**
     * 获取简短的商品信息列表，用于商品选择列表
     * ParId   父级ID
     * ktypeid 仓库ID
     * orderBy 排序根据
     *
     * @return 简要商品信息列表
     */
    @RequestMapping("/getBriefCommodityList")
    @ResponseBody
    public Map<String, Object> getBriefCommodityList(String ParId, String ktypeid, String orderBy) {
        List<CommodityBrief> commodityBriefs = commodityService.getBriefCommodityListByParentId(ParId, ktypeid, orderBy);
        Map<String, Object> res = new HashMap<>();
        if (commodityBriefs != null) {
            res.put("data", commodityBriefs);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取简短的商品信息列表，用于商品报价
     * ParId   父级ID
     *
     * @return 简要商品售价信息列表
     */
    @RequestMapping("/getBriefCommodityListWithSalePrices")
    @ResponseBody
    public Map<String, Object> getBriefCommodityListWithSalePrices(String ParId){
        List<CommodityBriefWithSalePricesResponse> responseList = commodityService.getBriefCommodityListWithSalePricesByParentId(ParId);
        Map<String, Object> res = new HashMap<>();
        if (responseList != null) {
            res.put("data", responseList);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取设置了库存预警的商品列表
     *
     * @return 设置了库存预警的商品列表
     */
    @RequestMapping("/getStockAlertList")
    @ResponseBody
    public Map<String, Object> getStockAlertList() {
        List<ResponseBean> beans = commodityService.getStockAlertList();
        Map<String, Object> res = new HashMap<>();
        if (beans != null) {
            res.put("data", beans);
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

    @RequestMapping("/addStockAlert")
    @ResponseBody
    public Map<String, Object> addStockAlert(String ptypeid, String ktypeid, String minimum) {
        Map<String, Object> res = new HashMap<>();
        if (Integer.parseInt(commodityDao.hasPtypeid(ptypeid)) > 0) {
            res.put("status", "1");
        } else {
            if (commodityService.insertStockAlert(ptypeid, ktypeid, minimum)) {
                res.put("status", "200");
            } else {
                res.put("status", "0");
            }
        }
        return res;
    }

    @RequestMapping("/modifyStockAlert")
    @ResponseBody
    public Map<String, Object> modifyStockAlert(String ptypeid, String ktypeid, String minimum) {
        Map<String, Object> res = new HashMap<>();
        if (commodityService.updateStockAlert(ptypeid, ktypeid, minimum)) {
            res.put("status", "200");
        } else {
            res.put("status", "0");
        }
        return res;
    }

}
