package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.Commodity;
import com.yu.arksys.bean.raw.CommodityBrief;
import com.yu.arksys.bean.raw.CommodityOfDataView;
import com.yu.arksys.bean.raw.StockAlert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PRTypeId: { 0001： 零售价, 0002: 预售价1, 0003: 预售价2, 0101: 最近进价 }
 */
@Qualifier("graspSqlSessionTemplate")
@Component("commodityDao")
public interface CommodityDao {

    // ============= 列表 =============== //
    @Select("SELECT ptypeid,ParId,leveal,pusercode,pfullname,RowIndex,isStop,deleted,LastBuyPrice,punitname FROM ptype WHERE ${conditions} ORDER BY RowIndex")
    List<Commodity> getCommodityListWithConditions(String conditions);

    @Select("SELECT ptypeid,ParId,leveal,pusercode,pfullname,RowIndex,isStop,deleted,LastBuyPrice,punitname FROM ptype WHERE pusercode='${pusercode}'")
    Commodity getCommodityByUserId(@Param("pusercode") String pusercode);

    @Select("SELECT t.ptypeid,t.ParId,t.pusercode,t.pfullname,t.RowIndex,ktypeid='${ktypeid}',Qty=(SELECT Qty FROM GoodsStocks t1 WHERE t1.PtypeId=t.ptypeid AND t1.KtypeId='${ktypeid}'),t.psonnum FROM ptype t WHERE t.ParId='${parid}' AND t.isStop='0' AND t.deleted='0' ORDER BY t.${orderBy}")
    List<CommodityBrief> getBriefCommodityList(@Param("parid") String parid, @Param("ktypeid") String ktypeid, @Param("orderBy") String orderBy);

    @Select("SELECT t.ptypeid,Qty=SUM(t.Qty),ParId=MAX(t.ParId),pusercode=MAX(t.pusercode),pfullname=MAX(t.pfullname),RowIndex=MAX(t.RowIndex),KtypeId='00000',psonnum=MAX(t.psonnum) FROM (SELECT ptype.ptypeid,GoodsStocks.Qty,ptype.ParId,ptype.pusercode,ptype.pfullname,ptype.RowIndex,GoodsStocks.KtypeId,ptype.psonnum FROM GoodsStocks RIGHT JOIN ptype ON GoodsStocks.PtypeId=ptype.ptypeid WHERE ptype.isStop='0' AND ptype.ParId='${parid}' AND ptype.deleted='0') t GROUP BY t.PtypeId ORDER BY t.${orderBy}")
    List<CommodityBrief> getBriefCommodityListNoStock(@Param("parid") String parid, @Param("orderBy") String orderBy);


    // ============= 信息 =============== //
    @Select("select pfullname from ptype where pusercode = '${pusercode}'")
    List<String> findFullNameByCode(@Param("pusercode") String pusercode);


    // ============= 价格 =============== //
    @Select("select Price from xw_P_PtypePrice where PTypeId = '${ptypeid}' and PRTypeId in ('0002','0003','0101')")
    List<String> getPricesByPtypeid(@Param("ptypeid") String ptypeid);

    @Select("select Price from xw_P_PtypePrice where PTypeId = (select top 1 ptypeid from ptype where pusercode =" +
            " '${pusercode}') and PRTypeId in ('0010','0002','0003','0101')")
    List<String> getPricesByPusercode(@Param("pusercode") String pusercode);

    // ============= 最近进价 =============== //
    @Select("select LastBuyPrice from ptype where ptypeid='${ptypeid}'")
    String getLastBuyPriceById(@Param("ptypeid") String ptypeid);

    // ============= 库存 =============== //
    @Select("SELECT Price,Total FROM GoodsStocks where PtypeId='${Ptypeid}' and KtypeId='00005'")
    String getAveragePriceById(@Param("Ptypeid") String Ptypeid);

    @Select("SELECT Total FROM GoodsStocks where PtypeId='${Ptypeid}' and KtypeId='00005'")
    String getTotalNumByIdMain(@Param("Ptypeid") String Ptypeid);

    @Select("SELECT Total FROM GoodsStocks WHERE PtypeId='${ptypeid}' and KtypeId='${ktypeid}'")
    String getTotalNumById(@Param("ptypeid") String ptypeid, @Param("ktypeid") String ktypeid);

    // ============= dataView =============== //

    // ============= stockAlerts ============= //
    @Select("SELECT t.ptypeid,t.ktypeid,t.minimum,Qty=(SELECT Qty FROM GoodsStocks t1 WHERE t1.PtypeId=t.ptypeid AND t1.KtypeId=t.ktypeid) FROM stockAlerts t")
    List<StockAlert> getStockAlertsList();

    @Insert("INSERT INTO stockAlerts(ptypeid,ktypeid,minimum) VALUES('${ptypeid}','${ktypeid}','${minimum}')")
    void addStockAlert(@Param("ptypeid") String ptypeid, @Param("ktypeid") String ktypeid, @Param("minimum") String minimum);

    @Update("UPDATE stockAlerts set minimum='${minimum}' WHERE ptypeid='${ptypeid}' AND ktypeid='${ktypeid}'")
    void modifyStockAlert(@Param("ptypeid") String ptypeid, @Param("ktypeid") String ktypeid, @Param("minimum") String minimum);

    @Select("SELECT count=count(*) FROM stockAlerts WHERE ptypeid='${ptypeid}'")
    String hasPtypeid(@Param("ptypeid") String ptypeid);
}
