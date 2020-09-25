package com.com.xk.qn.qnplatfrom.service.serviceImp;

import com.com.xk.qn.qnplatfrom.entity.User;
import com.com.xk.qn.qnplatfrom.entity.UserDetail;
import com.com.xk.qn.qnplatfrom.result.ResultCode;
import com.com.xk.qn.qnplatfrom.result.ResultJson;
import com.com.xk.qn.qnplatfrom.service.UserService;
import com.com.xk.qn.qnplatfrom.utils.JwtUtils;
import com.com.xk.qn.qnplatfrom.utils.ResponseUserToken;
import com.com.xk.qn.qnplatfrom.entity.UserRoles;
import com.com.xk.qn.qnplatfrom.exception.CustomException;
import com.com.xk.qn.qnplatfrom.mapper.UserMapper;
import com.com.xk.qn.qnplatfrom.mapper.UserRolesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private UserRolesMapper userRolesMapper;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void register(User user, String str) {

        //查询用户
        User oldUser = userMapper.findByUsername(user.getUsername());

        if (oldUser != null) {

           throw new CustomException(ResultJson.failure(ResultCode.BAD_REQUEST, "用户已存在"));
        }
        //加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPwd(encoder.encode(user.getPwd()));
        user.setCreatedTime(new Date(System.currentTimeMillis()));
        userMapper.insert(user);

        if (StringUtils.isNotBlank(str)){
            //权限插入
            String[] roles = str.split(",");
            for (String role : roles) {
                //如果原先有绑定权限就删除
               // userRolesMapper.deleteById(user.getId());

                UserRoles userRoles = new UserRoles();
                userRoles.setUserId(user.getId());
                userRoles.setRoleId(role);
                userRolesMapper.insert(userRoles);
            }
        }

    }

    @Override
    public ResponseUserToken login(String username, String password) {
        //用户验证
        final Authentication authentication = authenticate(username, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token ，查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
        final UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        //通过工具类生成token
         final String token = "Bearer "+jwtUtils.generateAccessToken(userDetail);

        //存储token
        jwtUtils.putToken(username, token);
        // 学习 测试用,把用户的信息也返回了
        return new ResponseUserToken(token, userDetail);
    }


    private Authentication authenticate(String username, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (DisabledException | BadCredentialsException e) {
            log.error("用户名密码错误");
            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, ResultCode.LOGIN_ERROR.getMsg()));
        }
    }
}
