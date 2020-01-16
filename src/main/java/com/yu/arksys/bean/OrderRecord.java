package com.yu.arksys.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrderRecord {

    public OrderRecord() { }

    public OrderRecord(Integer orderId, Integer factoryId, Integer orderStatusCode, Integer documentId, Date orderTime, Date arriveTime, Date payTime, float benefit, Integer detailed_id, float accountsPayable, float actualPayment) {
        this.orderId = orderId;
        this.factoryId = factoryId;
        this.orderStatusCode = orderStatusCode;
        this.documentId = documentId;
        this.orderTime = orderTime;
        this.arriveTime = arriveTime;
        this.payTime = payTime;
        this.benefit = benefit;
        this.detailed_id = detailed_id;
        this.accountsPayable = accountsPayable;
        this.actualPayment = actualPayment;
    }

    private Integer orderId;

    private Integer factoryId;

    private Integer orderStatusCode;

    private Integer documentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arriveTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    private float benefit;

    private Integer detailed_id;

    private float accountsPayable;

    private float actualPayment;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Integer getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(Integer orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public float getBenefit() {
        return benefit;
    }

    public void setBenefit(float benefit) {
        this.benefit = benefit;
    }

    public Integer getDetailed_id() {
        return detailed_id;
    }

    public void setDetailed_id(Integer detailed_id) {
        this.detailed_id = detailed_id;
    }

    public float getAccountsPayable() {
        return accountsPayable;
    }

    public void setAccountsPayable(float accountsPayable) {
        this.accountsPayable = accountsPayable;
    }

    public float getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(float actualPayment) {
        this.actualPayment = actualPayment;
    }
}
