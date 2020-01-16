package com.yu.arksys.dao.Imp;

import com.yu.arksys.dao.MappingDaoNew;
import com.yu.arksys.service.api.MemoryDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MappingDaoNewImp implements MappingDaoNew {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MemoryDataBase memoryDataBase;

    @Override
    public List<Map<String, String>> getMapping(String mappingName) {
        String sql = "select * from " + memoryDataBase.get(memoryDataBase.MAPPING_TABLE_NAMESPACE, mappingName);
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Map<String, String> row = new HashMap<>();
            List<String> fieldNames = (List<String>) memoryDataBase.get(memoryDataBase.MAPPING_FIELDS_NAMESPACE, mappingName);
            for (String fieldName : fieldNames) {
                row.put(fieldName, resultSet.getString(fieldName));
            }
            return row;
        });
    }

    @Override
    public void updateMapping(String mappingName, Integer mappingId, Map<String, String> mappingFields) {

    }

    @Override
    public void deleteMapping(String mappingName, Integer mappingId) {
        String key = ((List<String>) memoryDataBase.get(memoryDataBase.MAPPING_FIELDS_NAMESPACE, mappingName)).iterator().next();
        String sql = "delete from " + memoryDataBase.get(memoryDataBase.MAPPING_TABLE_NAMESPACE, mappingName) + " where " + key + "=" + mappingId.toString();
        jdbcTemplate.execute(sql);
    }
}
