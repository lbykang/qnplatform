package com.com.xk.qn.qnplatfrom.entity.dto;

import lombok.Data;

/**
 * @program: spring-security-demo
 * @description: 链接信息dto
 * @author: TianXiaoKang
 * @create: 2020-09-21 18:03
 **/
@Data
public class LinkDTO {

    /** 链接名称 */
    private String linkId;
    /** 链接名称 */
    private String typeId;
    /** 链接名称 */
    private String linkName;
    /** 链接排序id */
    private String linkOrder;
    /** 链接地址 */
    private String linkUrl;
    /** 链接图片地址 */
    private String linkImage;
    /** 链接类型 */
    private String linkType;
    /** 链接类型名称 */
    private String typeName;
    /** 类型排序 */
    private String typeOrder;
    /** 链接状态 */
    private String state;

}