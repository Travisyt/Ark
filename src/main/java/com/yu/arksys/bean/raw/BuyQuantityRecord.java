package com.yu.arksys.bean.raw;

public class BuyQuantityRecord {

    public BuyQuantityRecord() {
    }

    public BuyQuantityRecord(String vchcode, String bfullname, String kfullname, String pfullname, String qty, String date) {
        Vchcode = vchcode;
        this.bfullname = bfullname;
        this.kfullname = kfullname;
        this.pfullname = pfullname;
        Qty = qty;
        this.date = date;
    }

    String Vchcode;

    String bfullname;

    String kfullname;

    String pfullname;

    String Qty;

    String date;

    public String getVchcode() {
        return Vchcode;
    }

    public void setVchcode(String vchcode) {
        Vchcode = vchcode;
    }

    public String getBfullname() {
        return bfullname;
    }

    public void setBfullname(String bfullname) {
        this.bfullname = bfullname;
    }

    public String getKfullname() {
        return kfullname;
    }

    public void setKfullname(String kfullname) {
        this.kfullname = kfullname;
    }

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
