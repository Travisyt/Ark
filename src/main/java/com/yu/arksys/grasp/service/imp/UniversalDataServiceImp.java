package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.SalesDataPermonth;
import com.yu.arksys.exception.DataSourceException;
import com.yu.arksys.grasp.dao.DataViewDao;
import com.yu.arksys.grasp.service.UniversalDataService;
import com.yu.arksys.lastyear.dao.LastYearDataViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniversalDataServiceImp implements UniversalDataService {

    @Autowired
    DataViewDao dataViewDao;

    @Autowired
    LastYearDataViewDao lastYearDataViewDao;

    @Override
    public List<SalesDataPermonth> getUniversalSalesData(String ptypeid) {
        List<SalesDataPermonth> merge = new ArrayList<>();
        Map<String, SalesDataPermonth> temp = new HashMap<>();
        try {
            List<SalesDataPermonth> thisYear = dataViewDao.getUniversalSalesData(ptypeid);
            List<SalesDataPermonth> lastYear = lastYearDataViewDao.getUniversalSalesDataLastYear(ptypeid);
            thisYear.forEach(e -> {
                temp.put(e.getMonth(), e);
            });
            lastYear.forEach(e -> {
                if (temp.containsKey(e.getMonth())) {
                    double totalnum = Double.parseDouble(e.getTotalnum()) + Double.parseDouble(temp.get(e.getMonth()).getTotalnum());
                    double total = Double.parseDouble(e.getTotal()) + Double.parseDouble(temp.get(e.getMonth()).getTotal());
                    double profit = Double.parseDouble(e.getProfit()) + Double.parseDouble(temp.get(e.getMonth()).getProfit());
                    merge.add(new SalesDataPermonth(
                            e.getPfullname(),
                            Double.toString(totalnum),
                            Double.toString(total),
                            Double.toString(profit),
                            Double.toString(profit / total),
                            e.getMonth()
                    ));
                } else {
                    merge.add(e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return merge;
    }

    @Override
    public Map<String, Object> getUniversalDepartmentSalesData(String ptypeid) throws DataSourceException {
        Map<String, Object> res = new HashMap<>();
        List<String> ktypeidList = new ArrayList<>();
        ktypeidList.add("00005");
        ktypeidList.add("00009");
        ktypeidList.add("00002");
        try {
            ktypeidList.forEach(e -> {
                res.put(e, dataViewDao.getUniversalDepartmentSalesData(ptypeid, e));
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("getUniversalDepartmentSalesData()");
        }
        return res;
    }
}
