package com.yu.arksys.bean.response;

import com.yu.arksys.bean.api.ResponseBean;

public class CheckedSaleDraftResponse implements ResponseBean {

    public CheckedSaleDraftResponse() {
    }

    public CheckedSaleDraftResponse(String dlyorder, String etypeid, String ptypeid, String btypeid, String ktypeid, String vchcode, String qty, String price, String deleted, String date, String etype, String ptype, String btype, String ktype, String modified) {
        this.dlyorder = dlyorder;
        this.etypeid = etypeid;
        this.ptypeid = ptypeid;
        this.btypeid = btypeid;
        this.ktypeid = ktypeid;
        this.vchcode = vchcode;
        this.qty = qty;
        this.price = price;
        this.deleted = deleted;
        this.date = date;
        this.etype = etype;
        this.ptype = ptype;
        this.btype = btype;
        this.ktype = ktype;
        this.modified = modified;
    }

    private String dlyorder;
    private String etypeid;
    private String ptypeid;
    private String btypeid;
    private String ktypeid;
    private String vchcode;
    private String qty;
    private String price;
    private String deleted;
    private String date;
    private String etype;
    private String ptype;
    private String btype;
    private String ktype;
    private String modified;

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDlyorder() {
        return dlyorder;
    }

    public void setDlyorder(String dlyorder) {
        this.dlyorder = dlyorder;
    }

    public String getEtypeid() {
        return etypeid;
    }

    public void setEtypeid(String etypeid) {
        this.etypeid = etypeid;
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

    public String getVchcode() {
        return vchcode;
    }

    public void setVchcode(String vchcode) {
        this.vchcode = vchcode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getKtype() {
        return ktype;
    }

    public void setKtype(String ktype) {
        this.ktype = ktype;
    }
}
