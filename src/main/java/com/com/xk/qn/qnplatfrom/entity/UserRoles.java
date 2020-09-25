package com.com.xk.qn.qnplatfrom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_operator_role_relate")
public class UserRoles {
    @TableId(value ="id",type = IdType.UUID)
    private  String id;
    private  String userId;
    private  String roleId;

    /** 创建人 */
    private String createdBy;
    /** 创建时间 */
    private Date createdTime;
    /** 更新人 */
    private String updatedBy;
    /** 更新时间 */
    private Date updatedTime;
}
