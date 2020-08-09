package com.yu.arksys.bean;

import com.yu.arksys.bean.api.ResponseBean;

public class DetailedBillResponse implements ResponseBean {

    public DetailedBillResponse() {
    }

    public DetailedBillResponse(String vchcode, String atype, String btype, String etype, String ktype, String ptype, double qty, double price, double total, String date, String vchtype) {
        Vchcode = vchcode;
        this.atype = atype;
        this.btype = btype;
        this.etype = etype;
        this.ktype = ktype;
        Ptype = ptype;
        Qty = qty;
        this.price = price;
        this.total = total;
        this.date = date;
        Vchtype = vchtype;
    }

    private String Vchcode;

    public String getVchcode() {
        return Vchcode;
    }

    public void setVchcode(String vchcode) {
        Vchcode = vchcode;
    }

    private String atype;

    private String btype;

    private String etype;

    private String ktype;

    private String Ptype;

    private double Qty;

    private double price;

    private double total;

    private String date;

    private String Vchtype;

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getKtype() {
        return ktype;
    }

    public void setKtype(String ktype) {
        this.ktype = ktype;
    }

    public String getPtype() {
        return Ptype;
    }

    public void setPtype(String ptype) {
        Ptype = ptype;
    }

    public double getQty() {
        return Qty;
    }

    public void setQty(double qty) {
        Qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVchtype() {
        return Vchtype;
    }

    public void setVchtype(String vchtype) {
        Vchtype = vchtype;
    }
}
