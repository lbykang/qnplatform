package com.com.xk.qn.qnplatfrom.utils;

import java.util.UUID;

/**
 * @program: spring-security-demo
 * @description: 随机主键字符串生成
 * @author: TianXiaoKang
 * @create: 2020-09-22 10:36
 **/
public class UuidUtils {

    //获取32长度的UUID字符串
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}