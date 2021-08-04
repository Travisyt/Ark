package com.yu.arksys.controller;

import com.yu.arksys.exception.DataSourceException;
import com.yu.arksys.grasp.dao.DataViewDao;
import com.yu.arksys.grasp.service.DataViewService;
import com.yu.arksys.grasp.service.UniversalDataService;
import com.yu.arksys.lastyear.dao.LastYearDataViewDao;
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

    @Autowired
    UniversalDataService universalDataService;

    @Autowired
    DataViewDao dataViewDao;

    @Autowired
    LastYearDataViewDao lastYearDataViewDao;

    /**
     * 每月销售数据
     * @param ptypeid 商品编号
     * @return 每月数据
     */
    @RequestMapping("/getSalesDataPermonth")
    @ResponseBody
    public Map<String, Object> getSalesDataPermonth(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getSalesDataPermonth: ptypeid", ptypeid);
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

    /**
     * 去年至今的月销售情况
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getUniversalDataPermonth")
    @ResponseBody
    public Map<String, Object> getUniversalDataPermonth(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getUniversalDataPermonth: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", universalDataService.getUniversalSalesData(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取部门月销量
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getUniversalDepartmentDataPermonth")
    @ResponseBody
    public Map<String, Object> getUniversalDepartmentDataPermonth(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getUniversalDepartmentDataPermonth: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", universalDataService.getUniversalDepartmentSalesData(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取商品库存分布
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getCommodityStock")
    @ResponseBody
    public Map<String, Object> getCommodityStock(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getCommodityStock: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", dataViewDao.getCommodityStock(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取部门近三月销售情况
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getDepartmentSalesLastThreeMonth")
    @ResponseBody
    public Map<String, Object> getDepartmentSalesLastThreeMonth(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getDepartmentSalesLastThreeMonth: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", dataViewDao.getDepartmentSalesLastThreeMonths(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取客户近三月销售情况
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getCustomerSalesLastThreeMonths")
    @ResponseBody
    public Map<String, Object> getCustomerSalesLastThreeMonths(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getCustomerSalesLastThreeMonths: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", dataViewDao.getCustomerSalesLastThreeMonths(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

    /**
     * 获取职员销售均价
     * @param ptypeid 商品id
     * @return response map
     */
    @RequestMapping("/getEmployeeAverageSalesPrice")
    @ResponseBody
    public Map<String, Object> getEmployeeAverageSalesPrice(String ptypeid) {
        Map<String, String> params = new HashMap<>();
        params.put("getEmployeeAverageSalesPrice: ptypeid", ptypeid);
        LogUtils.dataAccessLog(params);
        Map<String, Object> res = new HashMap<>();
        try {
            res.put("data", dataViewDao.getEmployeeAverageSalesPrice(ptypeid));
            res.put("status", "200");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
        }
        return res;
    }

}
