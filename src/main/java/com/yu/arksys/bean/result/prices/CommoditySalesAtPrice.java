package com.yu.arksys.bean.result.prices;

/**
 * 某价格段位商品销售信息
 */
public class CommoditySalesAtPrice {
    String ptypeid;
    String pfullname;
    Float total;
    Float qty;
    Float price;
    Float profit;
    Float profitrate;
    String month;

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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public Float getProfitrate() {
        return profitrate;
    }

    public void setProfitrate(Float profitrate) {
        this.profitrate = profitrate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
