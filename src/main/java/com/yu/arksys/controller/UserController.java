package com.yu.arksys.controller;

import com.yu.arksys.bean.LoginUser;
import com.yu.arksys.bean.response.Status;
import com.yu.arksys.service.api.Logger;
import com.yu.arksys.service.api.MemoryDataBase;
import com.yu.arksys.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MemoryDataBase memoryDataBase;

    @Autowired
    private Logger logger;

    @RequestMapping("/tologin")
    public ModelAndView toLogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public Status login(LoginUser loginUser, HttpServletResponse response) {
        logger.info("userName: " + loginUser.getUserName() + ", password: " + loginUser.getPassword() + " login requesting");
        if (userService.checkUser(loginUser)) {
            Cookie cookie = new Cookie("identity", (String) memoryDataBase.get(memoryDataBase.USER_IDENTITY_NAMESPACE, loginUser.getUserName()));
            response.addCookie(cookie);
            return new Status(true, "success");
        }
        return new Status(false, "fail");
    }


}
