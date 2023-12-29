package com.yu.arksys.grasp.service.prices;

import com.yu.arksys.bean.result.prices.CommoditySalesAtPrice;

import java.util.List;

public interface PricesService {
    /**
     * 获取商品某月份的售价分布
     * @return List<CommoditySalesAtPrice>
     */
    List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid, int month);

    /**
     * 获取商品全年的售价分布
     * @return List<CommoditySalesAtPrice>
     */
    List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid);
}
