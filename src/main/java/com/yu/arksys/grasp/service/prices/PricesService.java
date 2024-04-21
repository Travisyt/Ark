package com.yu.arksys.grasp.service.prices;

import com.yu.arksys.bean.result.prices.CommoditySalesAtPrice;

import java.util.List;

public interface PricesService {
    /**
     * 获取商品近三个月的售价分布
     * @return List<CommoditySalesAtPrice>
     */
    List<CommoditySalesAtPrice> getSalesAtPricesLastThreeMonth(String ptypeid);

    /**
     * 获取商品某月份的售价分布
     * @return List<CommoditySalesAtPrice>
     */
    List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid, String yearMonth);

    /**
     * 获取商品全年的售价分布
     * @return List<CommoditySalesAtPrice>
     */
    List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid);
}
