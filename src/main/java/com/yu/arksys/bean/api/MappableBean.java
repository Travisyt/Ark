package com.yu.arksys.bean.api;

import com.yu.arksys.bean.TableMapInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface MappableBean {

    /**
     * 此方法是将 Bean 从 id 对应成实体
     * 格式: Map<ID, Map<字段名, 字段内容>>
     */
    ResponseBean getMappedBean(Map<String, Map<String, String>> mapper);

}
