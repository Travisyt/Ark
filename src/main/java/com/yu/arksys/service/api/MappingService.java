package com.yu.arksys.service.api;

import java.util.List;
import java.util.Map;

public interface MappingService {

    /**
     * 仅仅获得 编号——名称 映射
     */
    Map<String, Map<Integer, String>> getNameMapping();

    /**
     * 向映射中更新
     * @param mappingName 映射名称
     * @param mappingId 映射编号
     * @param mappingFields 映射字段键值对
     */
    void updateMapping(String mappingName, Integer mappingId, Map<String, String> mappingFields);

    /**
     * 获得 编号——所有信息 映射
     */
    Map<String, List<Map<String, String>>> getFullyMapping();

    void deleteMapping(String mappingName, Integer mappingId);

}
