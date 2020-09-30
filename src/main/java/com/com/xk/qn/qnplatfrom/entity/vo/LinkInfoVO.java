package com.com.xk.qn.qnplatfrom.entity.vo;

import lombok.Data;
@Data
public class LinkInfoVO {

    /** 链接类型名称 */
    private String typeName;
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
    /** 链接状态 */
    private String state;
}
