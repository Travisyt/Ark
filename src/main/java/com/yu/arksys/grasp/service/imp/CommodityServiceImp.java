package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.grasp.dao.CommodityDao;
import com.yu.arksys.grasp.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImp implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    /**
     * 信息查询
     */

    /**
     * 价格查询
     */
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
