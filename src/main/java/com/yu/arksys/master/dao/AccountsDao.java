package com.yu.arksys.master.dao;

import com.yu.arksys.bean.Accounts;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier(value = "masterSqlSessionTemplate")
@Component(value = "AccountsDao")
public interface AccountsDao {

//    @Select("")
//    List<Accounts> getAccountsData();
//


}
