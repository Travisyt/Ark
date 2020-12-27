package com.yu.arksys.bean.raw;

import com.yu.arksys.bean.result.CommodityUnit;

public class CommodityBrief {

    public CommodityBrief(String ptypeid, String parId, String pusercode, String pfullname, String rowIndex, String qty, String ktypeid, String psonnum) {
        this.ptypeid = ptypeid;
        ParId = parId;
        this.pusercode = pusercode;
        this.pfullname = pfullname;
        RowIndex = rowIndex;
        Qty = qty;
        this.ktypeid = ktypeid;
        this.psonnum = psonnum;
    }

    public CommodityBrief() {
    }

    private String ptypeid;

    private String ParId;

    private String pusercode;

    private String pfullname;

    private String RowIndex;

    private String Qty;

    private String ktypeid;

    private String psonnum;

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

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getPsonnum() {
        return psonnum;
    }

    public void setPsonnum(String psonnum) {
        this.psonnum = psonnum;
    }
}
