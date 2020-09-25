package com.com.xk.qn.qnplatfrom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.xk.qn.qnplatfrom.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 创建用户角色
     * @param userId
     * @param roleId
     * @return
     */
    int insertRole(String userId, String roleId);

    /**
     * 根据角色id查找角色
     * @param roleId
     * @return
     */
    Role findRoleById(String roleId);

    /**
     * 根据用户id查找该用户角色
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(@Param("userId") String userId);
}
