package com.yu.arksys.grasp.service;

public interface CommodityService {

    String getFirstPriceByPtypeid(String ptypeid);

    String getSecondPriceByPtypeid(String ptypeid);

    String getLastPurchasePriceByPtypeid(String ptypeid);

    String getLastPurchasePriceByPusercode(String pusercode);

    String getFirstPriceByPusercode(String pusercode);

    String getSecondPriceByPusercode(String pusercode);

}
