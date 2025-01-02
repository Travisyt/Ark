package com.yu.arksys.grasp.service.customer;

import com.yu.arksys.bean.raw.BusinessAddress;
import com.yu.arksys.bean.result.customer.CommodityCustomerSalesRecord;
import com.yu.arksys.bean.result.customer.CustomerCommoditySalesTotalRecord;
import com.yu.arksys.exception.IncompleteParamException;

import java.util.List;
import java.util.Map;

public interface BusinessRelatedUnitService {

    Map<String, Object> getBusinessList();

    Map<String, Object> getBusinessList(String parid);

    Map<String, Object> searchBusinessList(String keyWords);

    List<BusinessAddress> getBusinessAddress();

    List<BusinessAddress> getBusinessAddress(String btypeid) throws IncompleteParamException;

    /**
     * 购买某(类)商品的客户列表
     * @param ptypeid 商品（目录）ID
     * @param isCatalog 是否是目录ID
     * @return List<CommodityCustomerSalesRecord>
     */
    List<CommodityCustomerSalesRecord> getCommodityCustomerSalesData(String ptypeid, boolean isCatalog);

    /**
     * 客户累计购买的商品列表
     * @param btypeid 客户ID
     * @return List<CustomerCommoditySalesTotalRecord>
     */
    List<CustomerCommoditySalesTotalRecord> getCustomerCommoditySalesTotal(String btypeid);
}
