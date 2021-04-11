package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.SalesDataPermonth;
import com.yu.arksys.grasp.dao.DataViewDao;
import com.yu.arksys.grasp.service.DataViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataViewServiceImp implements DataViewService {

    @Autowired
    DataViewDao dataViewDao;

    @Override
    public List<SalesDataPermonth> getSalesDataPermonth(String ptypeid) {
        return dataViewDao.getSalesDataPermonth(ptypeid);
    }
}
