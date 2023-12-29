package com.yu.arksys.bean.result.accounting;

/**
 * 费用子目
 */
public class CostRecord {
    String ID;
    String costID;
    String costName;
    String costTypeID;
    String costTypeName;
    String costTotal;
    String time;
    String etypeid;
    String efullname;

    public String getCostID() {
        return costID;
    }

    public void setCostID(String costID) {
        this.costID = costID;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostTypeID() {
        return costTypeID;
    }

    public void setCostTypeID(String costTypeID) {
        this.costTypeID = costTypeID;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public String getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEtypeid() {
        return etypeid;
    }

    public void setEtypeid(String etypeid) {
        this.etypeid = etypeid;
    }

    public String getEfullname() {
        return efullname;
    }

    public void setEfullname(String efullname) {
        this.efullname = efullname;
    }
}
