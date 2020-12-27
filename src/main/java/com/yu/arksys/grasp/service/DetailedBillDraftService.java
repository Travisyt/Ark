package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.api.ResponseBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DetailedBillDraftService {

    /**
     * 根据条件获取当前的单据草稿
     * @param conditions 条件
     * @return 单据草稿
     */
    List<ResponseBean> getCurrentBillDraft(Map<String, String> conditions);

    /**
     * 根据经手人获取当前的销售草稿
     * @param employee 经手人ID
     * @return 当前的销售草稿
     */
    List<ResponseBean> getCurrentSaleDraftWithEmployee(String employee);

    List<RecordTuple> getCurrentBtypeMap(String etypeid);

    /**
     * 获取当前已准备的发货商品草稿列表
     * @param etypeid 经手人ID
     * @return 当前已准备的发货草稿
     */
    List<ResponseBean> getCheckedSaleDraft(String etypeid);

    /**
     * 将当天的草稿进行检查、合并
     * @param employee 经手人
     * @return 成功：true，失败：false
     */
    boolean checkSaleDraft(String employee);

    void checkSaleDraftDeletedMark(String dlyorder) throws Exception;

}
