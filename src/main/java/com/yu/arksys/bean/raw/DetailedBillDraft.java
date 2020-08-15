package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.api.MappableBean;
import com.yu.arksys.bean.api.ResponseBean;
import com.yu.arksys.bean.response.DetailedBillDraftResponse;

import java.util.Map;

public class DetailedBillDraft implements MappableBean {

    public DetailedBillDraft() {
    }

    public DetailedBillDraft(String vchcode, String atypeid, String btypeid, String etypeid, String ktypeid, String ptypeId, double qty, double price, double total, String date, String vchtype) {
        Vchcode = vchcode;
        this.atypeid = atypeid;
        this.btypeid = btypeid;
        this.etypeid = etypeid;
        this.ktypeid = ktypeid;
        PtypeId = ptypeId;
        Qty = qty;
        this.price = price;
        this.total = total;
        this.date = date;
        Vchtype = vchtype;
    }

    private String Vchcode;

    private String atypeid;

    private String btypeid;

    private String etypeid;

    private String ktypeid;

    private String PtypeId;

    private double Qty;

    private double price;

    private double total;

    private String date;

    private String Vchtype;

    public String getVchcode() {
        return Vchcode;
    }

    public void setVchcode(String vchcode) {
        Vchcode = vchcode;
    }

    public String getAtypeid() {
        return atypeid;
    }

    public void setAtypeid(String atypeid) {
        this.atypeid = atypeid;
    }

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getEtypeid() {
        return etypeid;
    }

    public void setEtypeid(String etypeid) {
        this.etypeid = etypeid;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getPtypeId() {
        return PtypeId;
    }

    public void setPtypeId(String ptypeId) {
        PtypeId = ptypeId;
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

    @Override
    public String toString() {
        return Vchcode + ", " + atypeid + ", " + btypeid + ", " + etypeid + ", " + ktypeid + ", " + PtypeId + ", " + Qty + ", " + price + ", " + total + ", " + date + ", " + Vchtype;
    }

    /**
     * 把自己(this)对应成字段值
     */
    @Override
    public ResponseBean getMappedBean(Map<String, Map<String, String>> mapper) {
        return new DetailedBillDraftResponse(
                this.Vchcode,
                mapper.get("atypeid").get(this.atypeid),
                mapper.get("btypeid").get(this.btypeid),
                mapper.get("etypeid").get(this.etypeid),
                mapper.get("ktypeid").get(this.ktypeid),
                mapper.get("ptypeid").get(this.PtypeId),
                this.Qty,
                this.price,
                this.total,
                this.date,
                mapper.get("vchtype").get(this.Vchtype)
                );
    }

}
