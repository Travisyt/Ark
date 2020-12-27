package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.BusinessAddress;
import com.yu.arksys.bean.raw.BusinessRelatedUnit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("graspSqlSessionTemplate")
@Component(value = "businessRelatedUnitDao")
public interface BusinessRelatedUnitDao {

    @Select("select bfullname from btype where btypeid = '${id}'")
    String findFullNameById(@Param("id") String id);

    @Select("select btypeid,parid,leveal,soncount,bfullname,Person from btype where deleted = '0' and parid = '${parid}'")
    List<BusinessRelatedUnit> getBusinessList(@Param("parid") String parid);

    @Update("insert into btypeaddress(btypeid,bfullname,longitude,latitude,mapname,entryemployee) values('${btypeid}','${bfullname}','${longitude}','${latitude}','${mapname}','${entryemployee}')")
    void insertBusinessAddress(@Param("btypeid") String btypeid, @Param("bfullname") String bfullname, @Param("longitude") String longitude, @Param("latitude") String latitude, @Param("mapname") String mapname, @Param("entryemployee") String entryemployee);

    @Update("update btypeaddress set longitude='${longitude}',latitude='${latitude}',mapname='${mapname}',entryemployee='${entryemployee}' where btypeid='${btypeid}'")
    void updateBusinessAddress(@Param("btypeid") String btypeid, @Param("longitude") String longitude, @Param("latitude") String latitude, @Param("mapname") String mapname, @Param("entryemployee") String entryemployee);

    @Select("select btypeid,bfullname,longitude,latitude,mapname,entryemployee,updatetime from btypeaddress")
    List<BusinessAddress> getBusinessAddress();

    @Select("select btypeid,bfullname,longitude,latitude,mapname,entryemployee,updatetime from btypeaddress where btypeid='${btypeid}'")
    BusinessAddress getBusinessAddressById(@Param("btypeid") String btypeid);

}
