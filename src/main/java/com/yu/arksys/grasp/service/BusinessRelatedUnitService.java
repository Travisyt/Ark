package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.raw.BusinessAddress;
import com.yu.arksys.exception.IncompleteParamException;

import java.util.List;
import java.util.Map;

public interface BusinessRelatedUnitService {

    Map<String, Object> getBusinessList();

    Map<String, Object> getBusinessList(String parid);

    List<BusinessAddress> getBusinessAddress();

    List<BusinessAddress> getBusinessAddress(String btypeid) throws IncompleteParamException;


}
