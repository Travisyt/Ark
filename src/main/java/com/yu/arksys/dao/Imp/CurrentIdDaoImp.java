package com.yu.arksys.dao.Imp;

import com.yu.arksys.dao.CurrentIdDao;
import com.yu.arksys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentIdDaoImp implements CurrentIdDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer getCurrentId(String tableName, String fieldName) {
        String sql = "select current_id from current_ids where table_name=tableName and field_name=fieldName";
        sql = sql.replaceAll("tableName", tableName).replaceAll("fieldName", fieldName);
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void changeCurrentId(String tableName, String fieldName, Integer currentId) {
        String sql = "update current_ids set current_id=currentId where table_name=tableName and field_name=fieldName";
        sql = sql.replaceAll("currentId", currentId.toString()).replaceAll("tableName", tableName).replaceAll("fieldName", fieldName);
        jdbcTemplate.execute(sql);
    }
}
