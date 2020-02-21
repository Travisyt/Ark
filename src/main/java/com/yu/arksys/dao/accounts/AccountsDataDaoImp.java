package com.yu.arksys.dao.accounts;

import com.yu.arksys.bean.AccountsRecord;
import com.yu.arksys.bean.api.AccountsDataBean;
import com.yu.arksys.service.api.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Repository
public class AccountsDataDaoImp implements AccountsDataDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Logger logger;

    @Override
    public void update(AccountsRecord accountsRecord) {
        String sql = "insert into accounts_data(" + accountsRecord.getFieldsString() + ") values (" + accountsRecord.getValuesString() + ")";
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from accounts_data where id = " + id.toString();
        jdbcTemplate.execute(sql);
    }

    private List<AccountsRecord> get(String sql) {
        System.out.println(sql);
        logger.info("executing sql :\n" + sql);
        return jdbcTemplate.query(sql, (resultSet, i) -> new AccountsRecord(
                resultSet.getInt(AccountsRecord.ID),
                resultSet.getDate(AccountsRecord.CREAT_TIME),
                resultSet.getInt(AccountsRecord.TARGET_ID),
                resultSet.getInt(AccountsRecord.ACCOUNT_ID),
                resultSet.getFloat(AccountsRecord.VALUE),
                resultSet.getInt(AccountsRecord.TYPE_ID),
                resultSet.getInt(AccountsRecord.STATUS_ID),
                resultSet.getInt(AccountsRecord.WAY_ID),
                resultSet.getDate(AccountsRecord.CHECK_TIME),
                resultSet.getString(AccountsRecord.NOTE)));
    }

    @Override
    public List<AccountsRecord> get(Integer pageSize, Integer pageNum) {
        int pageStart = (pageNum - 1) * pageSize;
        String sql = "select * from accounts_data order by create_time desc limit " + pageStart + "," + pageSize.toString();
        return get(sql);
    }

    @Override
    public Integer getNum() {
        String sql = "select count(*) from accounts_data";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<AccountsRecord> getOrderBy(Integer pageSize, Integer pageNum, String orderBy) {
        int pageStart = (pageNum - 1) * pageSize;
        String sql = "select * from accounts_data order by " + orderBy + " limit " + pageStart + "," + pageSize.toString();
        return get(sql);
    }

    @Override
    public List<AccountsRecord> getWithConditions(Integer pageSize, Integer pageNum, Map<String, String> conditions) {
        StringBuilder conditionSql = new StringBuilder();
        conditionSql.append("where ");
        for (Map.Entry<String, String> record : conditions.entrySet()) {
            conditionSql.append(record.getKey()).append(record.getValue()).append(" and ");
        }
        String cs = conditionSql.substring(0, conditionSql.lastIndexOf(" and "));
        int pageStart = (pageNum - 1) * pageSize;
        String sql = "select * from accounts_data " + cs + " order by create_time desc limit " + pageStart + "," + pageSize.toString();
        return get(sql);
    }

    @Override
    public Integer getNumWithConditions(Map<String, String> conditions) {
        StringBuilder conditionSql = new StringBuilder();
        conditionSql.append("where ");
        for (Map.Entry<String, String> record : conditions.entrySet()) {
            conditionSql.append(record.getKey()).append(record.getValue()).append(" and ");
        }
        String cs = conditionSql.substring(0, conditionSql.lastIndexOf(" and "));
        String sql = "select count(*) from accounts_data " + cs;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<AccountsRecord> getWithConditionsOrderBy(Integer pageSize, Integer pageNum, Map<String, String> conditions, String orderBy) {
        StringBuilder conditionSql = new StringBuilder();
        conditionSql.append("where ");
        for (Map.Entry<String, String> record : conditions.entrySet()) {
            conditionSql.append(record.getKey()).append(record.getValue()).append(" and ");
        }
        String cs = conditionSql.substring(0, conditionSql.lastIndexOf(" and "));
        int pageStart = (pageNum - 1) * pageSize;
        String sql = "select * from accounts_data " + cs + " order by " + orderBy + " limit " + pageStart + "," + pageSize.toString();
        return get(sql);
    }
}
