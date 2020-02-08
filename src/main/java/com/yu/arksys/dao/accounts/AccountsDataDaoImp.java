package com.yu.arksys.dao.accounts;

import com.yu.arksys.bean.AccountsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class AccountsDataDaoImp implements AccountsDataDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void update(AccountsRecord accountsRecord) {
        String sql = "insert into accounts_data("+accountsRecord.getFieldsString()+") values ("+accountsRecord.getValuesString()+")";
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from accounts_data where id = " + id.toString();
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<AccountsRecord> get(Integer pageSize, Integer pageNum) {
        int pageStart = (pageNum - 1) * pageSize + 1;
        String sql = "select * from accounts_data limit " + pageStart + "," + pageSize.toString();
        return jdbcTemplate.query(sql, (resultSet, i) -> new AccountsRecord(
                resultSet.getInt("id"),
                resultSet.getDate("create_time"),
                resultSet.getInt("target_id"),
                resultSet.getInt("account_id"),
                resultSet.getFloat("value"),
                resultSet.getInt("type_id"),
                resultSet.getInt("status_id"),
                resultSet.getInt("way_id"),
                resultSet.getDate("check_time"),
                resultSet.getString("note")));
    }

    @Override
    public List<AccountsRecord> getOrderBy(Integer pageSize, Integer pageNum, String orderBy) {
        return null;
    }

    @Override
    public List<AccountsRecord> getWithConditions(Integer pageSize, Integer pageNum, Map<String, String> conditions) {
        return null;
    }

    @Override
    public List<AccountsRecord> getWithConditionsOrderBy(Integer pageSize, Integer pageNum, Map<String, String> conditions, String orderBy) {
        return null;
    }
}
