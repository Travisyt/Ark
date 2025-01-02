package com.yu.arksys.bean.result.prices;

public class StockAveragePrice {
    String ptypeid;
    String ktypeid;
    Float stockAveragePrice;
    Float dynamicStockAveragePrice;

    public StockAveragePrice() {
    }

    public StockAveragePrice(String ptypeid, String ktypeid, Float stockAveragePrice, Float dynamicStockAveragePrice) {
        this.ptypeid = ptypeid;
        this.ktypeid = ktypeid;
        this.stockAveragePrice = stockAveragePrice;
        this.dynamicStockAveragePrice = dynamicStockAveragePrice;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getPtypeid() {
        return ptypeid;
    }

    public void setPtypeid(String ptypeid) {
        this.ptypeid = ptypeid;
    }

    public Float getStockAveragePrice() {
        return stockAveragePrice;
    }

    public void setStockAveragePrice(Float stockAveragePrice) {
        this.stockAveragePrice = stockAveragePrice;
    }

    public Float getDynamicStockAveragePrice() {
        return dynamicStockAveragePrice;
    }

    public void setDynamicStockAveragePrice(Float dynamicStockAveragePrice) {
        this.dynamicStockAveragePrice = dynamicStockAveragePrice;
    }
}
