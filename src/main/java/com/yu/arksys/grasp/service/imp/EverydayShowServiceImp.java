package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.SalesDataPublicPerday;
import com.yu.arksys.grasp.dao.DataViewDao;
import com.yu.arksys.grasp.service.EverydayShowService;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EverydayShowServiceImp implements EverydayShowService {

    private static List<String> etypeidList = Arrays.asList("00016", "00003", "00013", "00015", "00020", "00043", "00014");

    @Autowired
    DataViewDao dataViewDao;

    @Override
    public List<SalesDataPublicPerday> getSalesDataLastDay() {
        String currentDate = SQLUtils.getLastDate(false);
        List<SalesDataPublicPerday> result = new ArrayList<>();
        for (String e: etypeidList) {
            result.add(dataViewDao.getSalesDataPublicPerday(e, currentDate));
        }
        return result;
    }

    @Override
    public List<SalesDataPublicPerday> getSalesData(String date) {
        List<SalesDataPublicPerday> result = new ArrayList<>();
        for (String e: etypeidList) {
            result.add(dataViewDao.getSalesDataPublicPerday(e, date));
        }
        return result;
    }
}
