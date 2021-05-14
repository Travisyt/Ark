package com.yu.arksys.bean.raw;

public class DepartmentSalesOfCommodity {

    public DepartmentSalesOfCommodity() {
    }

    public DepartmentSalesOfCommodity(String kfullname, String ktypeid, String totalnum, String total, String profit, String profitrate) {
        this.kfullname = kfullname;
        this.ktypeid = ktypeid;
        this.totalnum = totalnum;
        this.total = total;
        this.profit = profit;
        this.profitrate = profitrate;
    }

    String kfullname;
    String ktypeid;
    String totalnum;
    String total;
    String profit;
    String profitrate;

    public String getKfullname() {
        return kfullname;
    }

    public void setKfullname(String kfullname) {
        this.kfullname = kfullname;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
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
