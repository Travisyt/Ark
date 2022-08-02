package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.raw.CommodityBrief;
import com.yu.arksys.bean.raw.CommodityOfDataView;
import com.yu.arksys.bean.response.CommodityBriefWithSalePricesResponse;
import com.yu.arksys.bean.result.CommodityUnit;

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

    List<String> getSalePriceByPtypeid(String ptypeid);

    // ========= 单位查询 ========== //
    Map<String, CommodityUnit> getMergedUnitMap();

    Map<String, CommodityUnit> getMergedUnitMapById(String ptypeid);

    Map<String, CommodityUnit> getMergedUnitMapByParId(String ParId);

    Map<String, CommodityUnit> getMergedUnitMapWithConditions(Map<String, String> conditions);

    // ========= 信息查询 ========== //
    List<ResponseBean> getCommodityListByParentId(String parentId, String orderBy);

    List<ResponseBean> getCommodityListByParentCode(String parentCode, String orderBy);

    List<ResponseBean> getFuzzySearchCommodityListByCode(String code);

    /**
     * 通过模糊查询获取简短的商品信息
     * @param name 模糊查询关键词
     * @return 符合条件的商品列表
     */
    List<CommodityBrief> getFuzzySearchCommodityListByPartName(String name, String ktypeid, String orderBy);

    List<ResponseBean> getFuzzySearchCommodityListByAll(String keyWord);

    /**
     * 获取简短的商品信息，用于商品列表或者其他一些不需要详细信息的情景
     * @param parentId 父目录ID
     * @param ktypeid 仓库ID
     * @param orderBy 排序根据
     * @return 子级商品列表
     */
    List<CommodityBrief> getBriefCommodityListByParentId(String parentId, String ktypeid, String orderBy);

    /**
     * 获取简短的商品信息，附带售价，用于询价
     * @param parentId 父目录ID
     * @return 子级商品列表
     */
    List<CommodityBriefWithSalePricesResponse> getBriefCommodityListWithSalePricesByParentId(String parentId);


    // **** dataView **** //

    List<CommodityOfDataView> getDataViewCommodityListByParentId(String parentId, String ktypeid, String orderBy);

    // ========= stockAlerts ========== //
    List<ResponseBean> getStockAlertList();

    boolean insertStockAlert(String ptypeid, String ktypeid, String minimum);

    boolean updateStockAlert(String ptypeid, String ktypeid, String minimum);


}
