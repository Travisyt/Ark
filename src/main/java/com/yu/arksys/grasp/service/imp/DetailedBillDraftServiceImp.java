package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.DetailedBillDraft;
import com.yu.arksys.bean.RecordTuple;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.grasp.dao.DetailedBillDraftDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import com.yu.arksys.utils.DataInfo;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetailedBillDraftServiceImp implements DetailedBillDraftService {

    @Autowired
    DetailedBillDraftDao detailedBillDraftDao;

    @Autowired
    BeanMappingService mappingService;

    @Override
    public List<ResponseBean> getCurrentBillDraft(Map<String, String> conditions) {
        List<DetailedBillDraft> detailedBillDrafts = detailedBillDraftDao.getDailyRecordsWithConditions(SQLUtils.getConditionString(conditions), SQLUtils.getCurrentDate());
        return mappingService.mapBean(detailedBillDrafts, DataInfo.detailedBillDraftMapTables());
    }

    /**
     * Vchtype: 单据类型
     * etypeid: 员工代码
     */
    @Override
    public List<ResponseBean> getCurrentSaleDraftWithEmployee(String employee) {
        Map<String, String> map = new HashMap<>();
        map.put("etypeid", "=" + employee);
        map.put("Vchtype", "=" + DetailedBillDraftDao.SALE_TYPE);
        return getCurrentBillDraft(map);
    }

    @Override
    public List<RecordTuple> getCurrentBtypeMap(String etypeid) {
        return mappingService.getMapByIdList(detailedBillDraftDao.getCurrentBtypeIdList(etypeid, SQLUtils.getCurrentDate()), "bfullname");
    }

}
