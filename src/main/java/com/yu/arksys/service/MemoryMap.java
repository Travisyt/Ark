package com.yu.arksys.service;

import com.yu.arksys.service.api.Logger;
import com.yu.arksys.service.api.MemoryDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Primary
public class MemoryMap implements MemoryDataBase {

    /**
     * 内存数据库
     * 单例模式
     */
    private static MemoryMap memoryMap = null;

    private MemoryMap() {
        this.namespaceMap = new HashMap<>();
    }

    public static final int FOREVER = 0;

    public static final int ONE_HOUR = 3600;

    @Bean
    public static MemoryMap getInstance() {
        if (memoryMap == null)
            MemoryMap.memoryMap = new MemoryMap();
        return MemoryMap.memoryMap;
    }

    private Map<String, Map<String, Record>> namespaceMap;

    @Autowired
    private Logger logger;

    @Override
    public void insert(String namespace, String key, Object value, Integer lifeTime) {
        if (! this.namespaceMap.containsKey(namespace))
            this.namespaceMap.put(namespace, new HashMap<>());
        this.namespaceMap.get(namespace).put(key, new Record(value, lifeTime));
        logger.info("insert into namespace: " + namespace + ", key: " + key + ", value: " + value + ", lifetime: " + lifeTime + "s");
    }

    @Override
    public Object get(String namespace, String key) {
        if (this.namespaceMap.containsKey(namespace)) {
            if (this.namespaceMap.get(namespace).containsKey(key)) {
                Record record = this.namespaceMap.get(namespace).get(key);
                if (record.isExpired()) {
                    this.namespaceMap.get(namespace).remove(key);
                    logger.info("namespace: " + namespace + ", key: " + key + " expired.");
                } else
                    return record.value();
            }
        }
        return null;
    }

    @Override
    public void delete(String namespace, String key) {
        if (this.namespaceMap.containsKey(namespace)) {
            this.namespaceMap.get(namespace).remove(key);
            logger.info("removed namespace.key: " + namespace + "." + key);
            if (this.namespaceMap.get(namespace).isEmpty()) {
                this.namespaceMap.remove(namespace);
                logger.info("removed namespace: " + namespace);
            }
        }
        this.logger.info("namespace: " + namespace + " not exist.");
    }

    /**
     * 一条记录
     */
    private static class Record {
        Record(Object value, Integer lifeTime) {
            this.value = value;
            if (lifeTime > 0)
                this.expiredTime = System.currentTimeMillis() + (lifeTime * 1000);
            else this.expiredTime = Long.MAX_VALUE;
        }

        private Object value;

        private Long expiredTime;

        public Boolean isExpired() {
            return this.expiredTime <= System.currentTimeMillis();
        }

        public Object value() {
            if (this.expiredTime > System.currentTimeMillis())
                return this.value;
            else
                return null;
        }

    }

}
