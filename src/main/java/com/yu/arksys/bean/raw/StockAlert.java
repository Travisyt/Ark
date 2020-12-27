package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.response.StockAlertResponse;

import java.util.Map;

public class StockAlert implements MappableBean {

    public StockAlert() {
    }

    public StockAlert(String ptypeid, String ktypeid, String minimum, String qty) {
        this.ptypeid = ptypeid;
        this.ktypeid = ktypeid;
        this.minimum = minimum;
        Qty = qty;
    }

    private String ptypeid;
    private String ktypeid;
    private String minimum;
    private String Qty;

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getPtypeid() {
        return ptypeid;
    }

    public void setPtypeid(String ptypeid) {
        this.ptypeid = ptypeid;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @Override
    public ResponseBean getMappedBean(Map<String, Map<String, String>> mapper) {
        return new StockAlertResponse(
                ptypeid,
                ktypeid,
                minimum,
                Qty,
                mapper.get("ptypeid").get(ptypeid),
                mapper.get("ktypeid").get(ktypeid)
        );
    }
}
