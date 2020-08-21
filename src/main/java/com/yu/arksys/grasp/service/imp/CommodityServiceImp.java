package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.raw.CommodityUnit;
import com.yu.arksys.bean.raw.RawCommodityUnit;
import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.dao.CommodityUnitDao;
import com.yu.arksys.grasp.service.CommodityService;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImp implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    CommodityUnitDao commodityUnitDao;

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
    public List<ResponseBean> getFuzzySearchCommodityListByName(String name) {
        return null;
    }

    @Override
    public List<ResponseBean> getFuzzySearchCommodityListByAll(String keyWord) {
        return null;
    }

    //==================== 价格查询 =======================//
    @Override
    public String getFirstPriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(0);
    }

    @Override
    public String getSecondPriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(1);
    }

    @Override
    public String getLastPurchasePriceByPtypeid(String ptypeid) {
        return commodityDao.getPricesByPtypeid(ptypeid).get(2);
    }

    @Override
    public String getLastPurchasePriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(2);
    }

    @Override
    public String getFirstPriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(0);
    }

    @Override
    public String getSecondPriceByPusercode(String pusercode) {
        return commodityDao.getPricesByPusercode(pusercode).get(1);
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMap() {
        return getMergedUnitMapWithConditions(new HashMap<>());
    }

    @Override
    public Map<String, CommodityUnit> getMergedUnitMapWithConditions(Map<String, String> conditions) {
        String conditionString = SQLUtils.getConditionString(conditions);
        List<RawCommodityUnit> units = commodityUnitDao.getRawCommodityUnitsWithConditions(conditionString);
        Map<String, CommodityUnit> result = new HashMap<>();

        units.forEach(unit -> {
            String id = unit.getPTypeId();
            String unit1 = "";
            CommodityUnit commodityUnit;
            if(!result.containsKey(id)) {
                commodityUnit = new CommodityUnit(id, "", "", "", "", "");
            } else commodityUnit = result.get(id);
            if (unit.getIsBase().equals("1")) commodityUnit.setBaseUnit(unit.getUnit1());
            else if (unit.getOrdid().equals("1")){
                commodityUnit.setSecondUnit(unit.getUnit1());
                commodityUnit.setSecondRate(unit.getURate());
            } else if (unit.getOrdid().equals("2")) {
                commodityUnit.setThirdUnit(unit.getUnit1());
                commodityUnit.setThirdRate(unit.getURate());
            }
            result.put(id, commodityUnit);
        });
        if (result.isEmpty()) throw new RuntimeException("商品单位获取失败");
        return result;
    }

}
