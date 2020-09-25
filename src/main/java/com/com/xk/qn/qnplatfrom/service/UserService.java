package com.com.xk.qn.qnplatfrom.service;

import com.com.xk.qn.qnplatfrom.entity.User;
import com.com.xk.qn.qnplatfrom.utils.ResponseUserToken;


public interface UserService {

    /**
     * 注册用户
     * @return
     */
    void register(User user,String str);


    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    ResponseUserToken login(String username, String password);





}
