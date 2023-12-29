package com.yu.arksys.grasp.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 与销售有关的的数据
 */
@Qualifier("graspSqlSessionTemplate")
@Component("SalesDataDao")
public interface SalesDataDao {



}
