package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.CheckedSaleDraft;
import com.yu.arksys.bean.raw.DetailedBillDraft;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select top ${pageSize} `Vch`code,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype from " +
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

    @Select("select Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype,DlyOrder from BakDly where " +
            "date=${date} and ${conditions}")
    List<DetailedBillDraft> getDailyRecordsWithConditions(@Param("conditions") String conditions,@Param("date") String date);

    @Select("select distinct btypeid from BakDly where date=${date} and etypeid='${etypeid}'")
    List<String> getCurrentBtypeIdList(@Param("etypeid") String etypeid, @Param("date") String date);

    @Select("select * from checkedSaleDraft where etypeid='${employee}' and date = ${date}")
    List<CheckedSaleDraft> getCheckedSaleDraftByEmployee(@Param("employee") String employee, @Param("date") String date);

    @Select("select Vchcode,atypeid,btypeid,etypeid,ktypeid,PtypeId,Qty,price,total,date,Vchtype,DlyOrder from BakDly where " +
            "date=${date} and Vchtype='11' and etypeid='${employee}'")
    List<DetailedBillDraft> getDetailedSaleDraftByEmployee(@Param("employee") String etypeid, @Param("date") String date);

    @Update("update checkedSaleDraft set ${field}='${value}' where dlyorder='${dlyorder}'")
    void updateCheckedSaleDraftIdentifiedByDlyOrder(@Param("dlyorder") String dlyorder, @Param("field") String field, @Param("value") String value);

    @Insert("insert into checkedSaleDraft(dlyorder,etypeid,ptypeid,btypeid,ktypeid,vchcode,qty,price,deleted,date,modified) val" +
            "ues('${dlyorder}','${etypeid}','${ptypeid}','${btypeid}','${ktypeid}','${vchcode}','${qty}','${price}','${d" +
            "eleted}',${date},'${modified}')")
    void insertCheckedSaleDraft(
            @Param("dlyorder") String dlyorder,
            @Param("etypeid") String etypeid,
            @Param("ptypeid") String ptypeid,
            @Param("btypeid") String btypeid,
            @Param("ktypeid") String ktypeid,
            @Param("vchcode") String vchcode,
            @Param("qty") String qty,
            @Param("price") String price,
            @Param("deleted") String deleted,
            @Param("date") String date,
            @Param("modified") String modified
    );

    @Update("update checkedSaleDraft set modified='0' where etypeid='${etypeid}'")
    void unsetModified(@Param("etypeid") String etypeid);

}
