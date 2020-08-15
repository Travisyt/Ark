package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.DetailedBillDraft;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "DetailedBillDraftDao")
public interface DetailedBillDraftDao {

    public static final String SALE_TYPE = "11";

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "BakDly where ID not in (select top ${frontPageNum} ID from BakDly where ${conditions} order by ${orderBy}) " +
            "and ${conditions} order by ${orderBy}")
    List<DetailedBillDraft> getRecordsWithOrderAndConditions(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("orderBy") String orderBy,
            @Param("conditions") String conditions
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "BakDly where ID not in (select top ${frontPageNum} ID from BakDly order by ${orderBy}) order by ${orderBy}")
    List<DetailedBillDraft> getRecordsWithOrder(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("orderBy") String orderBy
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "BakDly where ID not in (select top ${frontPageNum} ID from BakDly where ${conditions} and ${conditions}")
    List<DetailedBillDraft> getRecordsWithConditions(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum,
            @Param("conditions") String conditions
    );

    @Select("select top ${pageSize} Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
            "BakDly where ID not in (select top ${frontPageNum} ID from BakDly order by date desc) order by date desc")
    List<DetailedBillDraft> getRecords(
            @Param("pageSize") String pageSize,
            @Param("frontPageNum") String frontPageNum
            );

    @Select("select Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from BakDly where " +
            "date=${date} and ${conditions}")
    List<DetailedBillDraft> getDailyRecordsWithConditions(@Param("conditions") String conditions,@Param("date") String date);

    @Select("select distinct btypeid from BakDly where date=${date} and etypeid='${etypeid}'")
    List<String> getCurrentBtypeIdList(@Param("etypeid") String etypeid, @Param("date") String date);

}
