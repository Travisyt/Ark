package com.yu.arksys.bean.raw;

public class SalesDataPublicPerday {

    public SalesDataPublicPerday(){

    }

    public SalesDataPublicPerday(String etypeid, String efullname, String totalSales, String totalReturn, String totalDiscount, String netTotalSales) {
        this.etypeid = etypeid;
        this.efullname = efullname;
        this.totalSales = totalSales;
        this.totalReturn = totalReturn;
        this.totalDiscount = totalDiscount;
        this.netTotalSales = netTotalSales;
    }

    String etypeid;

    String efullname;

    String totalSales;

    String totalReturn;

    String totalDiscount;

    String netTotalSales;

    public String getEtypeid() {
        return etypeid;
    }

    public void setEtypeid(String etypeid) {
        this.etypeid = etypeid;
    }

    public String getEfullname() {
        return efullname;
    }

    public void setEfullname(String efullname) {
        this.efullname = efullname;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public String getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(String totalReturn) {
        this.totalReturn = totalReturn;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getNetTotalSales() {
        return netTotalSales;
    }

    public void setNetTotalSales(String netTotalSales) {
        this.netTotalSales = netTotalSales;
    }
}
