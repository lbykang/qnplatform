package com.com.xk.qn.qnplatfrom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("t_role")
public class Role {

    /**  id  */
    @TableId(value ="id",type = IdType.UUID)
    private String id;
    /**  角色名称  */
    private String roleName;
    /**  角色状态  */
    private String state;
    /**  排序id  */
    private String orderId;
    /** 创建人 */
    private String createdBy;
    /** 创建时间 */
    private Date createdTime;
    /** 更新人 */
    private String updatedBy;
    /** 更新时间 */
    private Date updatedTime;
}
