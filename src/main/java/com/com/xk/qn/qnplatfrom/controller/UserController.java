package com.com.xk.qn.qnplatfrom.controller;

import com.com.xk.qn.qnplatfrom.entity.User;
import com.com.xk.qn.qnplatfrom.entity.UserDetail;
import com.com.xk.qn.qnplatfrom.result.ResultCode;
import com.com.xk.qn.qnplatfrom.result.ResultJson;
import com.com.xk.qn.qnplatfrom.service.UserService;
import com.com.xk.qn.qnplatfrom.utils.ResponseUserToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    UserService userService;


    @GetMapping("/hello")
    public String hello(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetail userDetail = null;
        if (principal instanceof UserDetail) {
            userDetail = (UserDetail)principal;
        }
        return userDetail.getUsername()+userDetail.getPassword()+ userDetail.getId();
    }

    /**
     * 注册
     * @param user
     */
    @PostMapping("/register")
    public ResultJson signUp(User user , String str) {
        if (user==null){
            ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        userService.register(user,str);

         return ResultJson.success();

    }

    /**
     * 获取token
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultJson<ResponseUserToken> login(String username, String password) {
        final ResponseUserToken response = userService.login(username, password);
        return ResultJson.ok(response);
    }



}
