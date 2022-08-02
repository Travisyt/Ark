package com.yu.arksys.bean.response;

public class CommodityBriefWithSalePricesResponse {

    public CommodityBriefWithSalePricesResponse(String ptypeid, String parId, String pusercode, String pfullname, String rowIndex, String psonnum, String salePrice1, String salePrice2, String salePrice3) {
        this.ptypeid = ptypeid;
        ParId = parId;
        this.pusercode = pusercode;
        this.pfullname = pfullname;
        RowIndex = rowIndex;
        this.psonnum = psonnum;
        this.salePrice1 = salePrice1;
        this.salePrice2 = salePrice2;
        this.salePrice3 = salePrice3;
    }

    private String ptypeid;

    private String ParId;

    private String pusercode;

    private String pfullname;

    private String RowIndex;

    private String psonnum;

    private String salePrice1;

    private String salePrice2;

    private String salePrice3;

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

    public String getSalePrice1() {
        return salePrice1;
    }

    public void setSalePrice1(String salePrice1) {
        this.salePrice1 = salePrice1;
    }

    public String getSalePrice2() {
        return salePrice2;
    }

    public void setSalePrice2(String salePrice2) {
        this.salePrice2 = salePrice2;
    }

    public String getSalePrice3() {
        return salePrice3;
    }

    public void setSalePrice3(String salePrice3) {
        this.salePrice3 = salePrice3;
    }
}
