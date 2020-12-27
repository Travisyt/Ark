package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.api.ResponseBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yu.arksys.bean.api.MappableBean;
import java.util.Map;

public class Commodity {

    public Commodity() {
    }

    public Commodity(String ptypeid, String parId, String leveal, String pusercode, String pfullname, String rowIndex, String isStop, String deleted, double lastBuyPrice, String punitname) {
        this.ptypeid = ptypeid;
        ParId = parId;
        this.leveal = leveal;
        this.pusercode = pusercode;
        this.pfullname = pfullname;
        RowIndex = rowIndex;
        this.isStop = isStop;
        this.deleted = deleted;
        LastBuyPrice = lastBuyPrice;
        this.punitname = punitname;
    }

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

    public String getPtypeid() {
        return ptypeid;
    }

    public void setPtypeid(String ptypeid) {
        this.ptypeid = ptypeid;
    }

    public String getParId() {
        return ParId;
    }

    public void setParId(String parId) {
        ParId = parId;
    }

    public String getLeveal() {
        return leveal;
    }

    public void setLeveal(String leveal) {
        this.leveal = leveal;
    }

    public String getPusercode() {
        return pusercode;
    }

    public void setPusercode(String pusercode) {
        this.pusercode = pusercode;
    }

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
    }

    public String getRowIndex() {
        return RowIndex;
    }

    public void setRowIndex(String rowIndex) {
        RowIndex = rowIndex;
    }

    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public double getLastBuyPrice() {
        return LastBuyPrice;
    }

    public void setLastBuyPrice(double lastBuyPrice) {
        LastBuyPrice = lastBuyPrice;
    }

    public String getPunitname() {
        return punitname;
    }

    public void setPunitname(String punitname) {
        this.punitname = punitname;
    }
}
