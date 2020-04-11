package com.yu.arksys.bean.api;

import com.yu.arksys.bean.TableMapInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface MappableBean {

    ResponseBean getMappedBean(Map<String, Map<String, String>> mapper);

}
