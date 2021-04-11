package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.raw.SalesDataPermonth;

import java.util.List;

public interface DataViewService {

    List<SalesDataPermonth> getSalesDataPermonth(String ptypeid);

}
