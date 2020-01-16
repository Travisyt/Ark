package com.yu.arksys.service.api;

public interface MemoryDataBase {

    static final String USER_IDENTITY_NAMESPACE = "user_identities";

    static final String MAPPING_TABLE_NAMESPACE = "mapping_tables";

    static final String MAPPING_FIELDS_NAMESPACE = "mapping_fields";

    void insert(String namespace, String key, Object value, Integer lifeTime);

    Object get(String namespace, String key);

    void delete(String namespace, String key);

}
