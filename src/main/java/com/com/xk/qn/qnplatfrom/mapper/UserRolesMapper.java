package com.com.xk.qn.qnplatfrom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.xk.qn.qnplatfrom.entity.UserRoles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserRolesMapper extends BaseMapper<UserRoles> {
}
