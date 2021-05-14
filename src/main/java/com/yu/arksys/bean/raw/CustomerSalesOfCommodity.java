package com.yu.arksys.bean.raw;

public class CustomerSalesOfCommodity {

    public CustomerSalesOfCommodity() {
    }

    public CustomerSalesOfCommodity(String bfullname, String btypeid, String totalnum, String total, String profit, String profitrate) {
        this.bfullname = bfullname;
        this.btypeid = btypeid;
        this.totalnum = totalnum;
        this.total = total;
        this.profit = profit;
        this.profitrate = profitrate;
    }

    String bfullname;
    String btypeid;
    String totalnum;
    String total;
    String profit;
    String profitrate;

    public String getBfullname() {
        return bfullname;
    }

    public void setBfullname(String bfullname) {
        this.bfullname = bfullname;
    }

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getProfitrate() {
        return profitrate;
    }

    public void setProfitrate(String profitrate) {
        this.profitrate = profitrate;
    }
}
