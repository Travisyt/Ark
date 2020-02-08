package com.yu.arksys.dao.accounts;

import com.yu.arksys.bean.AccountsRecord;

import java.util.List;
import java.util.Map;

public interface AccountsDataDao {

    void update(AccountsRecord accountsRecord);

    void delete(Integer id);

    List<AccountsRecord> get(Integer pageSize, Integer pageNum);

    List<AccountsRecord> getOrderBy(Integer pageSize, Integer pageNum, String orderBy);

    /**
     *
     * @param conditions where 条件的键值对
     */
    List<AccountsRecord> getWithConditions(Integer pageSize, Integer pageNum, Map<String, String> conditions);

    List<AccountsRecord> getWithConditionsOrderBy(Integer pageSize, Integer pageNum, Map<String, String> conditions, String orderBy);

}
