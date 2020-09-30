package com.com.xk.qn.qnplatfrom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.com.xk.qn.qnplatfrom.entity.Link;
import com.com.xk.qn.qnplatfrom.entity.dto.LinkDTO;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring-security-demo
 * @description: 链接信息mapper
 * @author: TianXiaoKang
 * @create: 2020-09-21 17:39
 **/
@Mapper
@Component
public interface LinkMapper  extends BaseMapper<Link> {

    List<LinkDTO> selectAll();

    LinkInfoVO selectLinkById(String id);
}