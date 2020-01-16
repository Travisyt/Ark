package com.yu.arksys.dao.Imp;

import com.yu.arksys.configure.Properties;
import com.yu.arksys.dao.MappingDao;
import com.yu.arksys.service.api.Logger;
import com.yu.arksys.service.api.MemoryDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MappingDaoImp implements MappingDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MemoryDataBase memoryDataBase;

    @Autowired
    Logger logger;

    @Override
    public Map<Integer, Map<String, String>> getMapping(String mappingName) {
        String sql = "select * from " + memoryDataBase.get(memoryDataBase.MAPPING_TABLE_NAMESPACE, mappingName);
        List<Map<String, String>> res = jdbcTemplate.query(sql, new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, String> row = new HashMap<>();
                List<String> fieldNames = (List<String>) memoryDataBase.get(memoryDataBase.MAPPING_FIELDS_NAMESPACE, mappingName);
                for (String fieldName : fieldNames) {
                    row.put(fieldName, resultSet.getString(fieldName));
                }
                return row;
            }
        });
        Map<Integer, Map<String, String>> mapping = new HashMap<>();
        for (Map<String, String> fields : res) {
            // 遍历键值对，取出ID
            Integer id=-1;
            List<String> keysToRemove = new ArrayList<>();
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                if (entry.getKey().contains("id") || entry.getKey().contains("code")) {
                    id = Integer.parseInt(entry.getValue());
                    keysToRemove.add(entry.getKey());
                }
            }
            for (String key : keysToRemove) fields.remove(key);
            if (id != -1) mapping.put(id, fields);
            else logger.error("@MappingDaoImp.getMapping.for entry error");
        }
        return mapping;
    }

    @Override
    public void updateMapping(String mappingName,Integer mappingId , Map<String, String> mappingFields) {

    }

    @Override
    public void deleteMapping(String mappingName, Integer mappingId) {
        String key = ((List<String>) memoryDataBase.get(memoryDataBase.MAPPING_FIELDS_NAMESPACE, mappingName)).iterator().next();
        String sql = "delete from " + memoryDataBase.get(memoryDataBase.MAPPING_TABLE_NAMESPACE, mappingName) + " where " + key + "=" + mappingId.toString();
        jdbcTemplate.execute(sql);
    }
}
