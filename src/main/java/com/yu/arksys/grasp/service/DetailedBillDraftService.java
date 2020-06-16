package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.api.ResponseBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DetailedBillDraftService {

    List<ResponseBean> getCurrentBillDraft(Map<String, String> conditions);

    List<ResponseBean> getCurrentSaleDraftWithEmployee(String employee);

    List<RecordTuple> getCurrentBtypeMap(String etypeid);

}
