package com.yu.arksys.bean.result.customer;

public class CustomerCommoditySalesTotalRecord {
    String ptypeid;
    String pfullname;
    Float qty;
    Float total;
    Float profit;

    public String getPtypeid() {
        return ptypeid;
    }

    public void setPtypeid(String ptypeid) {
        this.ptypeid = ptypeid;
    }

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
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
