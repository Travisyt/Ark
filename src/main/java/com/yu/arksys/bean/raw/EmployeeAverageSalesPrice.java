package com.yu.arksys.bean.raw;

public class EmployeeAverageSalesPrice {

    public EmployeeAverageSalesPrice() {
    }

    public EmployeeAverageSalesPrice(String etypeid, String efullname, String averageprice) {
        this.etypeid = etypeid;
        this.efullname = efullname;
        this.averageprice = averageprice;
    }

    String etypeid;
    String efullname;
    String averageprice;

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

    public String getAverageprice() {
        return averageprice;
    }

    public void setAverageprice(String averageprice) {
        this.averageprice = averageprice;
    }
}
