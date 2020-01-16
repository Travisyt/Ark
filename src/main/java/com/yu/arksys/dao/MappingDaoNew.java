package com.yu.arksys.dao;

import java.util.List;
import java.util.Map;

public interface MappingDaoNew {

    List<Map<String, String>> getMapping(String mappingName);

    void updateMapping(String mappingName, Integer mappingId, Map<String, String> mappingFields);

    void deleteMapping(String mappingName, Integer mappingId);

}
