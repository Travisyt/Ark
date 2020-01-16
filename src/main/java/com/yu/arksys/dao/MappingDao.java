package com.yu.arksys.dao;

import java.util.Map;

public interface MappingDao {

    /**
     *
     */
    Map<Integer, Map<String, String>> getMapping(String mappingName);

    void updateMapping(String mappingName, Integer mappingId, Map<String, String> mappingFields);

    void deleteMapping(String mappingName, Integer mappingId);

}
