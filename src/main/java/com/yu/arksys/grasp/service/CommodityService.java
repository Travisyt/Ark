package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.raw.CommodityUnit;
import com.yu.arksys.bean.raw.RawCommodityUnit;

import java.util.List;
import java.util.Map;

public interface CommodityService {

    // ========= 价格查询 ========== //
    String getFirstPriceByPtypeid(String ptypeid);

    String getSecondPriceByPtypeid(String ptypeid);

    String getLastPurchasePriceByPtypeid(String ptypeid);

    String getLastPurchasePriceByPusercode(String pusercode);

    String getFirstPriceByPusercode(String pusercode);

    String getSecondPriceByPusercode(String pusercode);

    // ========= 单位查询 ========== //
    Map<String, CommodityUnit> getMergedUnitMap();

    Map<String, CommodityUnit> getMergedUnitMapWithConditions(Map<String, String> conditions);

    // ========= 信息查询 ========== //
    List<ResponseBean> getCommodityListByParentId(String parentId, String orderBy);

    List<ResponseBean> getCommodityListByParentCode(String parentCode, String orderBy);

    List<ResponseBean> getFuzzySearchCommodityListByCode(String code);

    List<ResponseBean> getFuzzySearchCommodityListByName(String name);

    List<ResponseBean> getFuzzySearchCommodityListByAll(String keyWord);

}
