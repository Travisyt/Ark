package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.dao.CommodityUnitDao;
import com.yu.arksys.grasp.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
