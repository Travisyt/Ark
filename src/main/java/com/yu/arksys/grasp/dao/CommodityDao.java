package com.yu.arksys.grasp.dao;

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

    @Select("select pfullname from ptype where pusercode = '${pusercode}'")
    List<String> findFullNameByCode(@Param("pusercode") String pusercode);

    @Select("select Price from xw_P_PtypePrice where PTypeId = '${ptypeid}' and PRTypeId in ('0002','0003','0101')")
    List<String> getPricesByPtypeid(@Param("ptypeid") String ptypeid);

    @Select("select Price from xw_P_PtypePrice where PTypeId = (select top 1 ptypeid from ptype where pusercode =" +
            " '${pusercode}') and PRTypeId in ('0010','0002','0003','0101')")
    List<String> getPricesByPusercode(@Param("pusercode") String pusercode);

}
