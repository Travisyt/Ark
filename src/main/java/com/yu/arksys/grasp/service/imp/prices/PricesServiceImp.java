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
    public List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid, int month) {
        if (month < 1 || month > 12){
            return new ArrayList<>();
        }
        return pricesDao.getSalesAtPriceOneMonth(ptypeid, Integer.toString(month));
    }

    @Override
    public List<CommoditySalesAtPrice> getSalesAtPrices(String ptypeid) {
        return pricesDao.getSalesAtPriceAll(ptypeid);
    }

}
