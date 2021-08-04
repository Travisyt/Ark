package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.raw.SalesDataPermonth;
import com.yu.arksys.exception.DataSourceException;

import java.util.List;
import java.util.Map;

public interface UniversalDataService {

    /**
     * 获取去年至今的月销售情况
     * @return SalesDataPermonth List
     */
    List<SalesDataPermonth> getUniversalSalesData(String ptypeid);

    /**
     * 获取每个仓库部门的月销量
     * @param ptypeid 商品id
     * @return map
     */
    Map<String, Object> getUniversalDepartmentSalesData(String ptypeid) throws DataSourceException;


}
