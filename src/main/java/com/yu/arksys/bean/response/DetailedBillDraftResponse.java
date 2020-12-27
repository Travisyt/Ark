package com.yu.arksys.bean.response;

import com.yu.arksys.bean.api.ResponseBean;

public class DetailedBillDraftResponse implements ResponseBean {
    public DetailedBillDraftResponse() {
    }

    public DetailedBillDraftResponse(String vchcode, String atype, String btype, String etype, String ktype, String ptype, double qty, double price, double total, String date, String vchtype, String dlyOrder, String btypeid, String ptypeid, String etypeid, String ktypeid) {
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
        DlyOrder = dlyOrder;
        this.btypeid = btypeid;
        Ptypeid = ptypeid;
        this.etypeid = etypeid;
        this.ktypeid = ktypeid;
    }

    private String Vchcode;

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

    private String DlyOrder;

    private String btypeid;

    private String Ptypeid;

    private String etypeid;

    private String ktypeid;

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getVchcode() {
        return Vchcode;
    }

    public void setVchcode(String vchcode) {
        Vchcode = vchcode;
    }

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

    public String getDlyOrder() {
        return DlyOrder;
    }

    public void setDlyOrder(String dlyOrder) {
        DlyOrder = dlyOrder;
    }

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getPtypeid() {
        return Ptypeid;
    }

    public void setPtypeid(String ptypeid) {
        Ptypeid = ptypeid;
    }

    public String getEtypeid() {
        return etypeid;
    }

    public void setEtypeid(String etypeid) {
        this.etypeid = etypeid;
    }
}
