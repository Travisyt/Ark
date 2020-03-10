package com.yu.arksys.grasp.service.imp;

import com.yu.arksys.bean.EmployeeAction;
import com.yu.arksys.grasp.dao.ActionLogDao;
import com.yu.arksys.grasp.service.ActionLogService;
import com.yu.arksys.utils.SQLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ActionLogServiceImp implements ActionLogService {

    @Autowired
    ActionLogDao actionLogDao;

    @Override
    public List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, String orderBy) {
        return actionLogDao.getActionLogWithOrder(pageSize.toString(), Integer.toString(pageSize * (pageNum - 1)), orderBy);
    }

    @Override
    public List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum) {
        return actionLogDao.getActionLog(pageSize.toString(), Integer.toString(pageSize * (pageNum - 1)));
    }

    @Override
    public List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, String orderBy, Map<String, String> conditions) {
        return actionLogDao.getActionLogWithConditionsAndOrder(pageSize.toString(), Integer.toString(pageSize * (pageNum - 1)), SQLUtils.getConditionString(conditions), orderBy);
    }

    @Override
    public List<EmployeeAction> getEmployeeAction(Integer pageSize, Integer pageNum, Map<String, String> conditions) {
        return actionLogDao.getActionLogWithConditions(pageSize.toString(), Integer.toString(pageSize * (pageNum - 1)), SQLUtils.getConditionString(conditions));
    }

    @Override
    public Integer getActionCount(Map<String, String> conditions) {
        return actionLogDao.getActionCount(SQLUtils.getConditionString(conditions));
    }

}
