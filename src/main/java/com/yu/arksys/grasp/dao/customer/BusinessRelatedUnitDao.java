package com.yu.arksys.grasp.dao.customer;

import com.yu.arksys.bean.raw.BusinessAddress;
import com.yu.arksys.bean.raw.BusinessRelatedUnit;
import com.yu.arksys.bean.result.customer.CommodityCustomerSalesRecord;
import com.yu.arksys.bean.result.customer.CustomerCommoditySalesTotalRecord;
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

    @Select("select btypeid,parid,leveal,soncount,bfullname,Person from btype where deleted = '0' and bfullname like '%${keyWords}%'")
    List<BusinessRelatedUnit> searchBusiness(@Param("keyWords") String keyWords);

    @Update("insert into btypeaddress(btypeid,bfullname,longitude,latitude,mapname,entryemployee) values('${btypeid}','${bfullname}','${longitude}','${latitude}','${mapname}','${entryemployee}')")
    void insertBusinessAddress(@Param("btypeid") String btypeid, @Param("bfullname") String bfullname, @Param("longitude") String longitude, @Param("latitude") String latitude, @Param("mapname") String mapname, @Param("entryemployee") String entryemployee);

    @Update("update btypeaddress set longitude='${longitude}',latitude='${latitude}',mapname='${mapname}',entryemployee='${entryemployee}' where btypeid='${btypeid}'")
    void updateBusinessAddress(@Param("btypeid") String btypeid, @Param("longitude") String longitude, @Param("latitude") String latitude, @Param("mapname") String mapname, @Param("entryemployee") String entryemployee);

    @Select("select btypeid,bfullname,longitude,latitude,mapname,entryemployee,updatetime from btypeaddress")
    List<BusinessAddress> getBusinessAddress();

    @Select("select btypeid,bfullname,longitude,latitude,mapname,entryemployee,updatetime from btypeaddress where btypeid='${btypeid}'")
    BusinessAddress getBusinessAddressById(@Param("btypeid") String btypeid);



    // 销售相关

    /**
     * 购买某商品的客户列表
     */
    @Select("SELECT btypeid=MAX(t.btypeid),bfullname=(SELECT bfullname FROM btype b WHERE b.btypeid=MAX(t.btypeid)),parid=(SELECT b1.parid FROM btype b1 WHERE b1.btypeid=MAX(t.btypeid)),parfullname=(SELECT b2.bfullname FROM btype b2 WHERE b2.btypeid=(SELECT b1.parid FROM btype b1 WHERE b1.btypeid=MAX(t.btypeid))),qty=-SUM(t.Qty),total=-SUM(t.total),profit=SUM(t.costtotal)-SUM(t.total) FROM DlySale t WHERE t.PtypeId = '${ptypeid}' GROUP BY t.btypeid ORDER BY total DESC")
    List<CommodityCustomerSalesRecord> getCommodityCustomerSalesData(@Param("ptypeid") String ptypeid);
    /**
     * 购买某类商品的客户列表
     */
    @Select("SELECT btypeid =MAX(t.btypeid),bfullname =(SELECT bfullname FROM btype b WHERE b.btypeid=MAX(t.btypeid)),parid =(SELECT b1.parid FROM btype b1 WHERE b1.btypeid=MAX(t.btypeid)),parfullname =(SELECT b2.bfullname FROM btype b2 WHERE b2.btypeid=(SELECT b1.parid FROM btype b1 WHERE b1.btypeid=MAX(t.btypeid))),qty =-SUM(t.Qty),total =-SUM(t.total),profit =SUM(t.costtotal)-SUM(t.total) FROM DlySale t WHERE (SELECT p.parid FROM ptype p WHERE p.ptypeid=t.PtypeId)='${parid}' GROUP BY t.btypeid ORDER BY total DESC")
    List<CommodityCustomerSalesRecord> getCommodityCatalogCustomerSales(@Param("parid") String parid);

    /**
     * 客户累计购买的商品列表
     */
    @Select("SELECT ptypeid =MAX(t.PtypeId),pfullname =(SELECT p1.pfullname FROM ptype p1 WHERE p1.ptypeid=MAX(t.PtypeId)),qty =-SUM(t.Qty),total =-SUM(t.total),profit =SUM(t.costtotal)-SUM(t.total) FROM DlySale t WHERE t.btypeid='${btypeid}' GROUP BY t.PtypeId ORDER BY total DESC")
    List<CustomerCommoditySalesTotalRecord> getCustomerCommoditySalesTotalData(@Param("btypeid") String btypeid);
}
