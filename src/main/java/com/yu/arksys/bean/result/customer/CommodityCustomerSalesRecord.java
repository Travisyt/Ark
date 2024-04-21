package com.yu.arksys.bean.result.customer;

public class CommodityCustomerSalesRecord {
    String btypeid;
    String bfullname;
    String parid;
    String parfullname;
    Float qty;
    Float total;
    Float profit;

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getBfullname() {
        return bfullname;
    }

    public void setBfullname(String bfullname) {
        this.bfullname = bfullname;
    }

    public String getParid() {
        return parid;
    }

    public void setParid(String parid) {
        this.parid = parid;
    }

    public String getParfullname() {
        return parfullname;
    }

    public void setParfullname(String parfullname) {
        this.parfullname = parfullname;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }
}
