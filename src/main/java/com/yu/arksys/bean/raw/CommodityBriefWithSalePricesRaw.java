package com.yu.arksys.bean.raw;

public class CommodityBriefWithSalePricesRaw {

    public CommodityBriefWithSalePricesRaw(String ptypeid, String parId, String pusercode, String pfullname, String rowIndex, String psonnum, String PRTypeId, String price) {
        this.ptypeid = ptypeid;
        ParId = parId;
        this.pusercode = pusercode;
        this.pfullname = pfullname;
        RowIndex = rowIndex;
        this.psonnum = psonnum;
        this.PRTypeId = PRTypeId;
        Price = price;
    }

    private String ptypeid;

    private String ParId;

    private String pusercode;

    private String pfullname;

    private String RowIndex;

    private String psonnum;

    private String PRTypeId;

    private String Price;

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

    public String getPsonnum() {
        return psonnum;
    }

    public void setPsonnum(String psonnum) {
        this.psonnum = psonnum;
    }

    public String getPRTypeId() {
        return PRTypeId;
    }

    public void setPRTypeId(String PRTypeId) {
        this.PRTypeId = PRTypeId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
