package com.yu.arksys.service;

import com.yu.arksys.bean.LoginUser;
import com.yu.arksys.dao.UserDao;
import com.yu.arksys.service.api.MemoryDataBase;
import com.yu.arksys.service.api.UserService;
import com.yu.arksys.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MemoryDataBase memoryDataBase;

    @Override
    public Boolean checkUser(LoginUser loginUser) {
        if (userDao.check(loginUser)) {
            String identity = RandomUtils.randomString(10);
            memoryDataBase.delete(memoryDataBase.USER_IDENTITY_NAMESPACE, loginUser.getUserName());
            memoryDataBase.insert(memoryDataBase.USER_IDENTITY_NAMESPACE, loginUser.getUserName(), identity, 0);
            return true;
        } else return false;
    }

    @Override
    public void signIn(LoginUser loginUser) throws UserNameExistException {
        if (userDao.existUser(loginUser.getUserName())) throw new UserNameExistException();
        else userDao.insert(loginUser);
    }
}
