package com.com.xk.qn.qnplatfrom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: spring-security-demo
 * @description: 链接信息
 * @author: TianXiaoKang
 * @create: 2020-09-21 17:32
 **/
@Data
@TableName("t_link")
public class Link {

    /** 主键id */
    @TableId(type= IdType.UUID)
    private String id;
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
    /** 创建人 */
    private String createdBy;
    /** 创建时间 */
    private Date createdTime;
    /** 更新人 */
    private String updatedBy;
    /** 更新时间 */
    private Date updatedTime;
}