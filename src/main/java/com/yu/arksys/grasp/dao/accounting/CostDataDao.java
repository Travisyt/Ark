package com.yu.arksys.grasp.dao.accounting;

import com.yu.arksys.bean.raw.accounting.CostType;
import com.yu.arksys.bean.raw.accounting.DetailedCostType;
import com.yu.arksys.bean.result.accounting.CostRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 与成本、费用核算相关数据
 */
@Qualifier("graspSqlSessionTemplate")
@Component("CostDataDao")
public interface CostDataDao {

    // CostType
    @Select("Select * From costType")
    List<CostType> getAllCostType();

    @Select("Select * From costType Where costTypeID = '${costTypeID}'")
    CostType getCostType(@Param("costTypeID") String costTypeID);

    @Update("Update costType Set costTypeName = '${costTypeName}' Where costTypeID = '${costTypeID}'")
    void updateCostType(@Param("costTypeID") String costTypeID, @Param("costTypeName") String costTypeName);

    @Insert("Insert into costType('costTypeID','costTypeName') values('${costTypeID}','${costTypeName}')")
    void insertCostType(@Param("costTypeID") String costTypeID, @Param("costTypeName") String costTypeName);


    // DetailedCostType
    @Select("Select * From detailedCostType")
    List<DetailedCostType> getAllDetailedCostType();

    @Select("Select * From detailedCostType Where costID = '${costID}'")
    DetailedCostType getDetailedCostType(@Param("costID") String costID);

    @Update("Update detailedCostType Set costName = '${costName}',costTypeID = '${costTypeID}' Where costID = '${costID}'")
    void updateDetailedCostType(@Param("costID") String costID, @Param("costName") String costName, @Param("costTypeID") String costTypeID);

    @Insert("Insert into detailedCostType('costID','costName','costTypeID') values('${costID}','${costName}','${costTypeID}')")
    void insertDetailedCostType(@Param("costID") String costID, @Param("costName") String costName, @Param("costTypeID") String costTypeID);


    // CostRecord
    @Select("SELECT *,costName=(SELECT costName FROM detailedCostType t_dct WHERE t_dct.costID = t_ca.costID),costTypeName=(SELECT costTypeName FROM costType t_ct WHERE t_ct.costTypeID=t_ca.costTypeID),efullname=(SELECT efullname FROM employee t_e WHERE t_e.etypeid=t_ca.etypeid) FROM costAccounting t_ca")
    List<CostRecord> getAllCostRecords();

    @Update("UPDATE costAccounting SET costID='${costID}',costTypeID='${costTypeID}',costTotal='${costTotal}',etypeid='${etypeid}',time='${time}' WHERE ID='${ID}'")
    void updateCostRecord(@Param("ID") String ID,
                          @Param("costID") String costID,
                          @Param("costTypeID") String costTypeID,
                          @Param("costTotal") String costTotal,
                          @Param("time") String time,
                          @Param("etypeid") String etypeid);

    @Insert("INSERT INTO costAccounting(ID,costID,costTypeID,costTotal,etypeid,time) VALUES('${ID}','${costID}','${costTypeID}','${costTotal}','${etypeid}','${time}')")
    void insertCostRecord(@Param("ID") String ID,
                          @Param("costID") String costID,
                          @Param("costTypeID") String costTypeID,
                          @Param("costTotal") String costTotal,
                          @Param("time") String time,
                          @Param("etypeid") String etypeid);

}
