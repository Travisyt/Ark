package com.yu.arksys.bean.api;

import java.util.HashMap;
import java.util.Map;

public class CustomMap<T> extends HashMap<String, Object> {

    public HashMap<String, T> transform(HashMap<String, Object> map) {
        return (HashMap<String, T>) map;
    }

}
