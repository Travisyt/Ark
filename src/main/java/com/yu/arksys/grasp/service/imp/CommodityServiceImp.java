package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.raw.*;
import com.yu.arksys.bean.response.CommodityBriefWithSalePricesResponse;
import com.yu.arksys.bean.result.CommodityUnit;
import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.dao.CommodityUnitDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.commodity.CommodityService;
import com.yu.arksys.utils.DataInfo;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommodityServiceImp implements
        CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    CommodityUnitDao commodityUnitDao;

    @Autowired
    BeanMappingService beanMappingService;

    //==================== 信息查询 =======================//
    @Override
    public List<ResponseBean> getCommodityListByParentId(String parentId, String orderBy) {
        return null;
    }

    @Override
    public List<ResponseBean> getCommodityListByParentCode(String parentCode, String orderBy) {
        return null;
    }

    @Override
    public List<ResponseBean> getFuzzySearchCommodityListByCode(String code) {
        return null;
    }

    @Override
    public List<CommodityBrief> getFuzzySearchCommodityListByPartName(String name, String ktypeid, String orderBy) {
        List<CommodityBrief> commodityBriefs;
        if (orderBy == null || orderBy.equals("")) {
            orderBy = "RowIndex";
        }
        if (ktypeid == null || ktypeid.equals("") || ktypeid.equals("00000")) {
            commodityBriefs = commodityDao.getCommodityByPartNameNoStock(name, orderBy);
        } else {
            commodityBriefs = commodityDao.getCommodityByPartName(name, ktypeid, orderBy);
        }
        return commodityBriefs;
    }

    @Override
    public List<ResponseBean> getFuzzySearchCommodityListByAll(String keyWord) {
        return null;
    }

    @Override
    public List<CommodityBrief> getBriefCommodityListByParentId(String parentId, String ktypeid, String orderBy) {
        List<CommodityBrief> commodityBriefs;
        if (parentId == null || parentId.equals("")) {
            parentId = "00000";
        }
        if (orderBy == null || orderBy.equals("")) {
            orderBy = "RowIndex";
        }
        if (ktypeid == null || ktypeid.equals("") || ktypeid.equals("00000")) {
            commodityBriefs = commodityDao.getBriefCommodityListNoStock(parentId, orderBy);
        } else {
            commodityBriefs = commodityDao.getBriefCommodityList(parentId, ktypeid, orderBy);
        }
        return commodityBriefs;
    }

    @Override
    public List<CommodityBriefWithSalePricesResponse> getBriefCommodityListWithSalePricesByParentId(String parentId) {
        if (parentId == null || parentId.equals("")) {
            parentId = "00000";
        }
        return mergeCommodityPrices(commodityDao.getCommodityBriefWithPricesRaw(parentId));
    }

    @Override
    public List<CommodityOfDataView> getDataViewCommodityListByParentId(String parentId, String ktypeid, String orderBy) {
        return null;
    }

    @Override
    public List<ResponseBean> getStockAlertList() {
        List<StockAlert> stockAlerts = commodityDao.getStockAlertsList();
        return beanMappingService.mapBean(stockAlerts, DataInfo.stockAlertMapTables());
    }

    @Override
    public boolean insertStockAlert(String ptypeid, String ktypeid, String minimum) {
        try {
            commodityDao.addStockAlert(ptypeid, ktypeid, minimum);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateStockAlert(String ptypeid, String ktypeid, String minimum) {
        try {
            commodityDao.modifyStockAlert(ptypeid, ktypeid, minimum);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //==================== 价格查询 =======================//
    @Override
    public String getFirstPriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(1);
    }

    @Override
    public String getSecondPriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(2);
    }

    @Override
    public String getLastPurchasePriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(10);
    }

    @Override
    public String getLastPurchasePriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(10);
    }

    @Override
    public String getFirstPriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(1);
    }

    @Override
    public String getSecondPriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(2);
    }

    @Override
    public List<String> getSalePriceByPtypeid(String ptypeid) {
        List<String> list;
        list = commodityDao.getPricesByPtypeid(ptypeid);
        list.remove(3);
        return list;
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMap() {
        return getMergedUnitMapWithConditions(new HashMap<>());
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMapByParId(String ParId) {
        List<CommodityUnitRaw> units = commodityUnitDao.getRawCommodityUnitsByParId(ParId);
        Map<String, CommodityUnit> result = mergeCommodityUnit(units);
        if (result.isEmpty()) throw new RuntimeException("商品单位获取失败");
        return result;
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMapById(String ptypeid) {
        List<CommodityUnitRaw> units = commodityUnitDao.getRawCommodityUnitsById(ptypeid);
        Map<String, CommodityUnit> result = mergeCommodityUnit(units);
        if (result.isEmpty()) throw new RuntimeException("商品单位获取失败");
        return result;
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMapWithConditions(Map<String, String> conditions) {
        String conditionString = SQLUtils.getConditionString(conditions);
        List<CommodityUnitRaw> units = commodityUnitDao.getRawCommodityUnitsWithConditions(conditionString);
        Map<String, CommodityUnit> result = mergeCommodityUnit(units);
        if (result.isEmpty()) throw new RuntimeException("商品单位获取失败");
        return result;
    }

    protected Map<String, CommodityUnit> mergeCommodityUnit(List<CommodityUnitRaw> units) {
        Map<String, CommodityUnit> result = new HashMap<>();
        units.forEach(unit -> {
            String id = unit.getPTypeId();
            String unit1 = "";
            CommodityUnit commodityUnit;
            if (!result.containsKey(id)) {
                commodityUnit = new CommodityUnit(id, "", "", "", "", "");
            } else commodityUnit = result.get(id);
            if (unit.getIsBase().equals("1")) commodityUnit.setBaseUnit(unit.getUnit1());
            else if (unit.getOrdid().equals("1")) {
                commodityUnit.setSecondUnit(unit.getUnit1());
                commodityUnit.setSecondRate(unit.getURate());
            } else if (unit.getOrdid().equals("2")) {
                commodityUnit.setThirdUnit(unit.getUnit1());
                commodityUnit.setThirdRate(unit.getURate());
            }
            result.put(id, commodityUnit);
        });
        return result;
    }

    protected List<CommodityBriefWithSalePricesResponse> mergeCommodityPrices(List<CommodityBriefWithSalePricesRaw> commoditys) {
        Map<String, CommodityBriefWithSalePricesResponse> map = new HashMap<>();
        commoditys.forEach(commodity -> {
            String id = commodity.getPtypeid();
            CommodityBriefWithSalePricesResponse item;
            if (map.containsKey(id)) {
                item = map.get(id);
            } else {
                item = new CommodityBriefWithSalePricesResponse(
                        id,
                        commodity.getParId(),
                        commodity.getPusercode(),
                        commodity.getPfullname(),
                        commodity.getRowIndex(),
                        commodity.getPsonnum(),
                        "",
                        "",
                        ""
                );
            }
            // 判断不是目录
            if (commodity.getPsonnum().equals("0")) {
                switch (commodity.getPRTypeId()) {
                    case "0001":{
                        item.setSalePrice1(commodity.getPrice());
                        break;
                    }
                    case "0002": {
                        item.setSalePrice2(commodity.getPrice());
                        break;
                    }
                    case "0003": {
                        item.setSalePrice3(commodity.getPrice());
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
            map.put(id, item);
        });
        return new ArrayList<>(map.values());
    }

}
