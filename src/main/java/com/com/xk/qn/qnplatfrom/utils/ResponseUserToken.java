package com.com.xk.qn.qnplatfrom.utils;

import com.com.xk.qn.qnplatfrom.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUserToken {
    private String token;
    private UserDetail userDetail;
}