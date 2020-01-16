package com.yu.arksys.bean;

public class Status {

    public Status(Boolean status, String info) {
        this.status = status;
        this.info = info;
    }

    public Status() {

    }

    private Boolean status;

    private String info;

    public void setStatus(Boolean successful) {
        status = successful;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }
}
