package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.raw.SalesDataPublicPerday;

import java.util.List;

public interface EverydayShowService {

    List<SalesDataPublicPerday> getSalesDataLastDay();

    List<SalesDataPublicPerday> getSalesData(String date);

}
