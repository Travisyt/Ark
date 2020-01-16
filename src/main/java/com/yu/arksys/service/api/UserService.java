package com.yu.arksys.service.api;

import com.yu.arksys.bean.LoginUser;
import com.yu.arksys.service.UserNameExistException;

public interface UserService {

    Boolean checkUser(LoginUser loginUser);

    void signIn(LoginUser loginUser) throws UserNameExistException;

}
