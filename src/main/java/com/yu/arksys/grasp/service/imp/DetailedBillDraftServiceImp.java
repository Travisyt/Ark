package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.DetailedBillDraft;
import com.yu.arksys.bean.DetailedBillDraftResponse;
import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.grasp.dao.DetailedBillDraftDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.DetailedBillDraftService;
import com.yu.arksys.service.api.MemoryDataBase;
import com.yu.arksys.utils.DataInfo;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return mappingService.mapBean(detailedBillDrafts, DataInfo.DetailedBillDraftMapTables());
    }

}
