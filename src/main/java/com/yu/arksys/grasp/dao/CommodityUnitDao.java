package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.CommodityUnitRaw;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component("commodityUnitDao")
public interface CommodityUnitDao {

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit")
    List<CommodityUnitRaw> getAllRawCommodityUnits();

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit where PTypeId='${PTypeId}'")
    List<CommodityUnitRaw> getRawCommodityUnitsById(@Param("PTypeId") String pTypeId);

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit where ${conditions}")
    List<CommodityUnitRaw> getRawCommodityUnitsWithConditions(@Param("conditions") String conditions);

    @Select("SELECT xw_PtypeUnit.PTypeId,xw_PtypeUnit.Unit1,xw_PtypeUnit.URate,xw_PtypeUnit.Ordid,xw_PtypeUnit.IsBase FROM (SELECT ptypeid FROM ptype WHERE ParId='${ParId}') t INNER JOIN xw_PtypeUnit ON t.ptypeid=xw_PtypeUnit.PTypeId")
    List<CommodityUnitRaw> getRawCommodityUnitsByParId(@Param("ParId") String ParId);



}
