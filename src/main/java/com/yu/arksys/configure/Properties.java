package com.yu.arksys.configure;

import com.yu.arksys.service.api.Logger;
import com.yu.arksys.service.api.MemoryDataBase;
import com.yu.arksys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Properties {

    public Properties() {

    }

    public static final String ALL_MAPPING_TABLE_NAME = "all";

    @Autowired
    Logger logger;

    @Autowired
    Environment environment;

    @Autowired
    MemoryDataBase memoryDataBase;

    /**
     * 是否已经加载
     */
    public static Boolean loaded = false;

    private static final String PREFIX = "ark.mapping.";

    private static final String TABLE_SUFFIX = ".tableName";

    private static final String FIELD_SUFFIX = ".fieldNames";

    public void load() {
        // 已经载入内存则返回
        if (loaded) return;
        // 未载入则全部载入
        List<String> mappingNames = StringUtils.splitAsList(environment.getProperty("ark.mapping.tables"), ",");
        memoryDataBase.insert(memoryDataBase.MAPPING_TABLE_NAMESPACE, ALL_MAPPING_TABLE_NAME, mappingNames, 0);
        for (String mappingName : mappingNames) {
            memoryDataBase.insert(memoryDataBase.MAPPING_TABLE_NAMESPACE, mappingName, environment.getProperty(PREFIX + mappingName + TABLE_SUFFIX), 0);
            logger.info("environment get property name: " + PREFIX + mappingName + FIELD_SUFFIX);
            logger.info("property: " + environment.getProperty(PREFIX + mappingName + FIELD_SUFFIX));
            List<String> fields = StringUtils.splitAsList(environment.getProperty(PREFIX + mappingName + FIELD_SUFFIX), ",");
            memoryDataBase.insert(memoryDataBase.MAPPING_FIELDS_NAMESPACE, mappingName, fields, 0);
        }
        loaded = true;
        logger.info("< ================= mapping info loaded ================== >");
    }

}
