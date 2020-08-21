package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.CommodityUnit;
import com.yu.arksys.bean.raw.RawCommodityUnit;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Qualifier("graspSqlSessionTemplate")
@Component("commodityUnitDao")
public interface CommodityUnitDao {

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit")
    List<RawCommodityUnit> getAllRawCommodityUnits();

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit where PTypeId=${PTypeId}")
    List<RawCommodityUnit> getRawCommodityUnitsById(@Param("PTypeId") String pTypeId);

    @Select("select PTypeId,Unit1,URate,Ordid,IsBase from xw_PtypeUnit where ${conditions}")
    List<RawCommodityUnit> getRawCommodityUnitsWithConditions(@Param("conditions") String conditions);



}
