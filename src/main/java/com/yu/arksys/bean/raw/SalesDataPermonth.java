package com.yu.arksys.bean.raw;

public class SalesDataPermonth {

    public SalesDataPermonth() {
    }

    public SalesDataPermonth(String pfullname, String totalnum, String total, String profit, String profitrate, String month) {
        this.pfullname = pfullname;
        this.totalnum = totalnum;
        this.total = total;
        this.profit = profit;
        this.profitrate = profitrate;
        this.month = month;
    }

    String pfullname;
    String totalnum;
    String total;
    String profit;
    String profitrate;
    String month;

    public String getPfullname() {
        return pfullname;
    }

    public void setPfullname(String pfullname) {
        this.pfullname = pfullname;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
