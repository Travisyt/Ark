package com.yu.arksys.bean;

public class CommodityUnit {

    public CommodityUnit() {
    }

    public CommodityUnit(String PTypeId, String unit1, String URate, String isBase) {
        this.PTypeId = PTypeId;
        Unit1 = unit1;
        this.URate = URate;
        IsBase = isBase;
    }

    private String PTypeId;

    private String Unit1;

    private String URate;

    private String IsBase;

    public String getPTypeId() {
        return PTypeId;
    }

    public void setPTypeId(String PTypeId) {
        this.PTypeId = PTypeId;
    }

    public String getUnit1() {
        return Unit1;
    }

    public void setUnit1(String unit1) {
        Unit1 = unit1;
    }

    public String getURate() {
        return URate;
    }

    public void setURate(String URate) {
        this.URate = URate;
    }

    public String getIsBase() {
        return IsBase;
    }

    public void setIsBase(String isBase) {
        IsBase = isBase;
    }
}
