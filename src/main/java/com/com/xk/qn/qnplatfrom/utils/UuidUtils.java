package com.com.xk.qn.qnplatfrom.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;

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

    public static void main(String[] args) {
        String [] sp = "a.acb.as".split(".");
        String [] sps = "a.acb.as".split("\\.");
        System.out.println(Arrays.toString(sp));
        System.out.println(Arrays.toString(sps));
    }
}