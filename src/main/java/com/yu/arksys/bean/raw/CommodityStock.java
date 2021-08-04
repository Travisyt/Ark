package com.yu.arksys.bean.raw;

public class CommodityStock {

    public CommodityStock() {
    }

    public CommodityStock(String ktypeid, String kfullname, String qty) {
        this.ktypeid = ktypeid;
        this.kfullname = kfullname;
        Qty = qty;
    }

    String ktypeid;
    String kfullname;
    String Qty;

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getKfullname() {
        return kfullname;
    }

    public void setKfullname(String kfullname) {
        this.kfullname = kfullname;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }
}
