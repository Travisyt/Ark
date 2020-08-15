package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.DetailedBill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 销售、销售退货详细表: DlySale
 */
@Qualifier("graspSqlSessionTemplate")
@Component(value = "DetailedBillDao")
public interface DetailedBillDao {

    public static final String SALE_TYPE = "11";

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "DlySale where ID not in (select top ${frontPageNum} ID from DlySale where ${conditions} order by ${orderBy}) " +
            "and ${conditions} order by ${orderBy}")
    List<DetailedBill> getRecordsWithOrderAndConditions(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("orderBy") String orderBy,
            @Param("conditions") String conditions
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "DlySale where ID not in (select top ${frontPageNum} ID from DlySale order by ${orderBy}) order by ${orderBy}")
    List<DetailedBill> getRecordsWithOrder(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("orderBy") String orderBy
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "DlySale where ID not in (select top ${frontPageNum} ID from DlySale where ${conditions} and ${conditions}")
    List<DetailedBill> getRecordsWithConditions(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("conditions") String conditions
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "DlySale where ID not in (select top ${frontPageNum} ID from DlySale order by date desc) order by date desc")
    List<DetailedBill> getRecords(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum
    );

    @Select("select Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from DlySale where " +
            "date=${date} and ${conditions}")
    List<DetailedBill> getDailyRecordsWithConditions(@Param("conditions") String conditions,@Param("date") String date);


}
