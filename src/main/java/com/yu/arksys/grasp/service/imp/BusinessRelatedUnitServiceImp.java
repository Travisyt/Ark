package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.raw.BusinessAddress;
import com.yu.arksys.bean.raw.BusinessRelatedUnit;
import com.yu.arksys.exception.IncompleteParamException;
import com.yu.arksys.grasp.dao.BusinessRelatedUnitDao;
import com.yu.arksys.grasp.service.BusinessRelatedUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessRelatedUnitServiceImp implements BusinessRelatedUnitService {

    @Autowired
    BusinessRelatedUnitDao businessRelatedUnitDao;

    @Override
    public Map<String, Object> getBusinessList() {
        return getBusinessList("0");
    }

    @Override
    public Map<String, Object> getBusinessList(String parid) {
        Map<String, Object> res = new HashMap<>();
        try {
            List<BusinessRelatedUnit> businessRelatedUnits = businessRelatedUnitDao.getBusinessList(parid);
            res.put("data", businessRelatedUnits);
            res.put("status", "200");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "0");
            return res;
        }
    }

    public List<BusinessAddress> getBusinessAddress() {
        return businessRelatedUnitDao.getBusinessAddress();
    }

    public List<BusinessAddress> getBusinessAddress(String btypeid) throws IncompleteParamException {
        if (btypeid != null && !btypeid.equals("")) {
            List<BusinessAddress> res = new ArrayList<>();
            res.add(businessRelatedUnitDao.getBusinessAddressById(btypeid));
            return res;
        } else {
            throw new IncompleteParamException("参数 btypeid 缺失。");
        }
    }

}
