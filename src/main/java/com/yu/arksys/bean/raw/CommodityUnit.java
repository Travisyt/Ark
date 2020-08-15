package com.yu.arksys.bean.raw;

/**
 * 经过分类的商品单位信息
 */
public class CommodityUnit {

    public CommodityUnit() {
    }

    public CommodityUnit(String PTypeId, String baseUnit, String secondUnit, String thirdUnit, String secondRate, String thirdRate) {
        this.PTypeId = PTypeId;
        this.baseUnit = baseUnit;
        this.secondUnit = secondUnit;
        this.thirdUnit = thirdUnit;
        this.secondRate = secondRate;
        this.thirdRate = thirdRate;
    }

    private String PTypeId;

    private String baseUnit;

    private String secondUnit;

    private String thirdUnit;

    private String secondRate;

    private String thirdRate;

    public String getPTypeId() {
        return PTypeId;
    }

    public void setPTypeId(String PTypeId) {
        this.PTypeId = PTypeId;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public String getSecondUnit() {
        return secondUnit;
    }

    public void setSecondUnit(String secondUnit) {
        this.secondUnit = secondUnit;
    }

    public String getThirdUnit() {
        return thirdUnit;
    }

    public void setThirdUnit(String thirdUnit) {
        this.thirdUnit = thirdUnit;
    }

    public String getSecondRate() {
        return secondRate;
    }

    public void setSecondRate(String secondRate) {
        this.secondRate = secondRate;
    }

    public String getThirdRate() {
        return thirdRate;
    }

    public void setThirdRate(String thirdRate) {
        this.thirdRate = thirdRate;
    }
}
