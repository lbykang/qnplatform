package com.com.xk.qn.qnplatfrom.entity.vo;

import com.com.xk.qn.qnplatfrom.entity.Link;
import lombok.Data;

import java.util.List;

/**
 * @program: spring-security-demo
 * @description: 链接信息前端展示信息
 * @author: TianXiaoKang
 * @create: 2020-09-21 17:43
 **/
@Data
public class LinkVO {

    /** 链接类型名称 */
    private String typeName;

    /** 类型排序 */
    private String typeOrder;

    private List<Link> linkList;
}