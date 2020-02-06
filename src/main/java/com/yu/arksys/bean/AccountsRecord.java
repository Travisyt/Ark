package com.yu.arksys.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yu.arksys.utils.RandomUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AccountsRecord {

    public AccountsRecord() { };

    public AccountsRecord(Integer id, Date createTime, Integer targetId, Integer accountId, Float value, Integer typeId, Integer statusId, Integer wayId, Date checkTime, String note) {
        this.id = id;
        this.createTime = createTime;
        this.targetId = targetId;
        this.accountId = accountId;
        this.value = value;
        this.typeId = typeId;
        this.statusId = statusId;
        this.wayId = wayId;
        this.checkTime = checkTime;
        this.note = note;
    }

    public static AccountsRecord test() {
        return new AccountsRecord(
                RandomUtils.randomInteger(10),
                new Date(System.currentTimeMillis()),
                RandomUtils.randomInteger(100),
                RandomUtils.randomInteger(5),
                Float.parseFloat(RandomUtils.randomInteger(999999).toString()), RandomUtils.randomInteger(5),
                RandomUtils.randomInteger(5),
                RandomUtils.randomInteger(10),
                new Date(System.currentTimeMillis()+1000000L),
                RandomUtils.randomString(180)
        );
    }

    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer targetId;

    private Integer accountId;

    private Float value;

    private Integer typeId;

    private Integer statusId;

    private Integer wayId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getWayId() {
        return wayId;
    }

    public void setWayId(Integer wayId) {
        this.wayId = wayId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

}
