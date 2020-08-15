package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;

import java.util.Map;

public class Commodity implements MappableBean {

    private String ptypeid;

    private String ParId;

    private String leveal;

    private String pusercode;

    private String pfullname;

    private String RowIndex;

    private String isStop;

    private String deleted;

    private double LastBuyPrice;

    private String punitname;

    

    @Override
    public ResponseBean getMappedBean(Map<String, Map<String, String>> mapper) {
        return null;
    }

}
