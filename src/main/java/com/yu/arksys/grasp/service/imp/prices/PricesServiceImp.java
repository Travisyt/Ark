package com.yu.arksys.grasp.service.imp.prices;


import com.yu.arksys.bean.result.prices.CommoditySalesAtPrice;
import com.yu.arksys.grasp.dao.prices.PricesDao;
import com.yu.arksys.grasp.service.prices.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricesServiceImp implements PricesService {

    @Autowired
    PricesDao pricesDao;

    @Override
    public List<CommoditySalesAtPrice> getSalesAtPricesLastThreeMonth(String ptypeid) {
        return pricesDao.getSalesAtPriceLastThreeMonth(ptypeid);
    }

    @Override
    public List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid, String yearMonth) {
        int month = Integer.parseInt(yearMonth.substring(5, 7));
        if (month < 1 || month > 12){
            return new ArrayList<>();
        }
        return pricesDao.getSalesAtPriceOneMonth(ptypeid, yearMonth);
    }

    @Override
    public List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid) {
        return pricesDao.getSalesAtPriceAll(ptypeid);
    }

}
