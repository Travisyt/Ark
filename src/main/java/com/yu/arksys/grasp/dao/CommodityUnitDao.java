package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.CommodityUnit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component("commodityUnitDao")
public interface CommodityUnitDao {

    @Select("select PTypeId,Unit1,URate,IsBase from xw_PtypeUnit")
    List<CommodityUnit> getAllCommodityUnits();

    @Select("select PTypeId,Unit1,URate,IsBase from xw_PtypeUnit where PTypeId=${PTypeId}")
    CommodityUnit getCommodityUnitsById(@Param("PTypeId") String pTypeId);

}
