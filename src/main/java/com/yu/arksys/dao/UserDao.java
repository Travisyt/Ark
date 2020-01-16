package com.yu.arksys.dao;

import com.yu.arksys.bean.LoginUser;

public interface UserDao {

    Boolean existUser(String userName);

    void insert(LoginUser loginUser) throws RuntimeException;

    Boolean check(LoginUser loginUser);

}
