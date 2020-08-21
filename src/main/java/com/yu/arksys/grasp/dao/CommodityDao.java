package com.yu.arksys.grasp.dao;

import com.yu.arksys.bean.raw.Commodity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    // ============= 信息 =============== //
    @Select("select pfullname from ptype where pusercode = '${pusercode}'")
    List<String> findFullNameByCode(@Param("pusercode") String pusercode);


    // ============= 价格 =============== //
    @Select("select Price from xw_P_PtypePrice where PTypeId = '${ptypeid}' and PRTypeId in ('0002','0003','0101')")
    List<String> getPricesByPtypeid(@Param("ptypeid") String ptypeid);

    @Select("select Price from xw_P_PtypePrice where PTypeId = (select top 1 ptypeid from ptype where pusercode =" +
            " '${pusercode}') and PRTypeId in ('0010','0002','0003','0101')")
    List<String> getPricesByPusercode(@Param("pusercode") String pusercode);

}
