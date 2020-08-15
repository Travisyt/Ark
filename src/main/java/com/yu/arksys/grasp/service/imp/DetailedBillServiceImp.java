package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.DetailedBill;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.grasp.dao.DetailedBillDao;
import com.yu.arksys.grasp.service.BeanMappingService;
import com.yu.arksys.grasp.service.DetailedBillService;
import com.yu.arksys.utils.DataInfo;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DetailedBillServiceImp implements DetailedBillService {

    @Autowired
    DetailedBillDao detailedBillDao;

    @Autowired
    BeanMappingService mappingService;

    @Override
    public List<ResponseBean> getCurrentBill(Map<String, String> conditions) {
        List<DetailedBill> detailedBill = detailedBillDao.getDailyRecordsWithConditions(SQLUtils.getConditionString(conditions), SQLUtils.getCurrentDate());
        return mappingService.mapBean(detailedBill, DataInfo.detailedBillMapTables());
    }

}
