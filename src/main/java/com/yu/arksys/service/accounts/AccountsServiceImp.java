package com.yu.arksys.service.accounts;

import com.yu.arksys.bean.AccountsRecord;
import com.yu.arksys.dao.accounts.AccountsDataDao;
import com.yu.arksys.service.api.accounts.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountsServiceImp implements AccountsService {

    @Autowired
    private AccountsDataDao accountsDataDao;

    @Override
    public Map<String, Object> getData(Integer pageSize, Integer pageNum, String orderBy, Map<String, String> conditions) {
        orderBy = orderBy + ",create_time desc";
        Map<String, Object> map = new HashMap<>();
        map.put("num", accountsDataDao.getNumWithConditions(conditions));
        map.put("data", accountsDataDao.getWithConditionsOrderBy(pageSize, pageNum, conditions, orderBy));
        return map;
    }

    @Override
    public Map<String, Object> getData(Integer pageSize, Integer pageNum, Map<String, String> conditions) {
        Map<String, Object> map = new HashMap<>();
        map.put("num", accountsDataDao.getNumWithConditions(conditions));
        map.put("data", accountsDataDao.getWithConditions(pageSize, pageNum, conditions));
        return map;
    }

    @Override
    public Map<String, Object> getData(Integer pageSize, Integer pageNum, String orderBy) {
        orderBy = orderBy + ",create_time desc";
        Map<String, Object> map = new HashMap<>();
        map.put("num", accountsDataDao.getNum());
        map.put("data", accountsDataDao.getOrderBy(pageSize, pageNum, orderBy));
        return map;
    }

    @Override
    public Map<String, Object> getData(Integer pageSize, Integer pageNum) {
        Map<String, Object> map = new HashMap<>();
        map.put("num", accountsDataDao.getNum());
        map.put("data", accountsDataDao.get(pageSize, pageNum));
        return map;
    }
}
