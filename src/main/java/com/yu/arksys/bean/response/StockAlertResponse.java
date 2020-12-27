package com.yu.arksys.bean.response;

import com.yu.arksys.bean.api.ResponseBean;

public class StockAlertResponse implements ResponseBean {

    public StockAlertResponse() {
    }

    public StockAlertResponse(String ptypeid, String ktypeid, String minimum, String qty, String pfullname, String kfullname) {
        this.ptypeid = ptypeid;
        this.ktypeid = ktypeid;
        this.minimum = minimum;
        Qty = qty;
        this.pfullname = pfullname;
        this.kfullname = kfullname;
    }

    private String ptypeid;
    private String ktypeid;
    private String minimum;
    private String Qty;
    private String pfullname;
    private String kfullname;

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

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
    }

    public String getKfullname() {
        return kfullname;
    }

    public void setKfullname(String kfullname) {
        this.kfullname = kfullname;
    }
}
