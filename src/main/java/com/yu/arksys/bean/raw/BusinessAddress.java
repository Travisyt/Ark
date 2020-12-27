package com.yu.arksys.bean.raw;

public class BusinessAddress {

    public BusinessAddress() {
    }

    public BusinessAddress(String btypeid, String bfullname, String longitude, String latitude, String mapname, String entryemployee, String updatetime) {
        this.btypeid = btypeid;
        this.bfullname = bfullname;
        this.longitude = longitude;
        this.latitude = latitude;
        this.mapname = mapname;
        this.entryemployee = entryemployee;
        this.updatetime = updatetime;
    }

    private String btypeid;

    private String bfullname;

    private String longitude;

    private String latitude;

    private String mapname;

    private String entryemployee;

    private String updatetime;

    public String getBtypeid() {
        return btypeid;
    }

    public void setBtypeid(String btypeid) {
        this.btypeid = btypeid;
    }

    public String getBfullname() {
        return bfullname;
    }

    public void setBfullname(String bfullname) {
        this.bfullname = bfullname;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getMapname() {
        return mapname;
    }

    public void setMapname(String mapname) {
        this.mapname = mapname;
    }

    public String getEntryemployee() {
        return entryemployee;
    }

    public void setEntryemployee(String entryemployee) {
        this.entryemployee = entryemployee;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
