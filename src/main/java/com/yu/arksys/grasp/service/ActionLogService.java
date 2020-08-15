package com.yu.arksys.grasp.service;

import com.yu.arksys.bean.raw.EmployeeAction;

import java.util.List;
import java.util.Map;

public interface ActionLogService {

    List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, String orderBy);

    List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum);

    List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, String orderBy, Map<String, String> conditions);

    List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, Map<String, String> conditions);

    Integer getActionCount(Map<String, String> conditions);

    List<String> getFieldEnum(String field, String keyword);

}
