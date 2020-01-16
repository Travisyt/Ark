package com.yu.arksys.dao.Imp;

import com.yu.arksys.bean.LoginUser;
import com.yu.arksys.dao.UserDao;
import com.yu.arksys.service.api.MemoryDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean existUser(String userName) {
        String sql = "select count(*) from user_info where user_name = ?";
        return !jdbcTemplate.queryForList(sql, userName).isEmpty();
    }

    @Override
    public void insert(LoginUser loginUser) throws RuntimeException {
        if (existUser(loginUser.getUserName()))
            throw new RuntimeException("用户已存在");
        String sql = "insert into user_info(user_name, password) values(?, ?)";
        jdbcTemplate.update(sql, loginUser.getUserName(), loginUser.getPassword());
    }

    @Override
    public Boolean check(LoginUser loginUser) {
        String sql = "select (select password from user_info where user_name = ?) <=> ? as equal from DUAL";
        List<Map<String, Object>> res = jdbcTemplate.queryForList(sql, loginUser.getUserName(), loginUser.getPassword());
        return (Long) res.iterator().next().get("equal") == 1L;
    }
}
