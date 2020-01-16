package com.yu.arksys.service;

import com.yu.arksys.configure.Properties;
import com.yu.arksys.dao.MappingDao;
import com.yu.arksys.dao.MappingDaoNew;
import com.yu.arksys.service.api.MappingService;
import com.yu.arksys.service.api.MemoryDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MappingServiceImp implements MappingService {

    @Autowired
    MemoryDataBase memoryDataBase;

    @Autowired
    MappingDaoNew mappingDao;

    @Override
    public Map<String, Map<Integer, String>> getNameMapping() {

        return null;
    }

    @Override
    public void updateMapping(String mappingName, Integer mappingId, Map<String, String> mappingFields) {

    }

    @Autowired
    Properties properties;

    @Override
    public Map<String, List<Map<String, String>>> getFullyMapping() {
        properties.load();
        List<String> tables = (List<String>) memoryDataBase.get(memoryDataBase.MAPPING_TABLE_NAMESPACE, Properties.ALL_MAPPING_TABLE_NAMES);
        Map<String, List<Map<String, String>>> fullyMapping = new HashMap<>();
        for (String table : tables) {
            fullyMapping.put(table, mappingDao.getMapping(table));
        }
        return fullyMapping;
    }

    @Override
    public void deleteMapping(String mappingName, Integer mappingId) {

    }
}
