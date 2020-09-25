package com.com.xk.qn.qnplatfrom.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_user")
public class User implements Serializable {

    /**  id  */
    @TableId(value ="id",type = IdType.UUID)
    private String id;

    /**  username  */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**  password  */
    @NotBlank(message = "密码不能为空")
    private String pwd;
    /**  账号  */
    private String account;
    /**  邮箱  */
    private String email;
    /**  电话  */
    private String number;

    /** 创建人 */
    private String createdBy;
    /** 更新人 */
    private String updatedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;


}
