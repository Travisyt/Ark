package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.api.Distinguishable;
import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.response.CheckedSaleDraftResponse;

import java.util.Map;

public class CheckedSaleDraft implements MappableBean, Distinguishable {
    @Override
    public String getDistinguishCode() {
        return this.ptypeid + this.ktypeid + this.qty + this.price;
    }

    public CheckedSaleDraft() {
    }

    public CheckedSaleDraft(String dlyorder, String etypeid, String ptypeid, String btypeid, String ktypeid, String vchcode, String qty, String price, String deleted, String date, String modified) {
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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
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

    @Override
    public ResponseBean getMappedBean(Map<String, Map<String, String>> mapper) {
        return new CheckedSaleDraftResponse(
                this.dlyorder,
                this.etypeid,
                this.ptypeid,
                this.etypeid,
                this.ktypeid,
                this.vchcode,
                this.qty,
                this.price,
                this.deleted,
                this.date,
                mapper.get("etypeid").get(this.etypeid),
                mapper.get("ptypeid").get(this.ptypeid),
                mapper.get("btypeid").get(this.btypeid),
                mapper.get("ktypeid").get(this.ktypeid),
                this.modified
        );
    }
}
