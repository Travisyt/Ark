package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.api.ResponseBean;

import java.util.List;
import java.util.Map;

public interface DetailedBillService {

    List<ResponseBean> getCurrentBill(Map<String, String> conditions);

}
