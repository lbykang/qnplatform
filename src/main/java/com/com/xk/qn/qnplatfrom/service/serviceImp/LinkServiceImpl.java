package com.com.xk.qn.qnplatfrom.service.serviceImp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.com.xk.qn.qnplatfrom.entity.Link;
import com.com.xk.qn.qnplatfrom.entity.LinkType;
import com.com.xk.qn.qnplatfrom.entity.dto.LinkDTO;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkFileVo;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkVO;
import com.com.xk.qn.qnplatfrom.mapper.LinkMapper;
import com.com.xk.qn.qnplatfrom.mapper.LinkTypeMapper;
import com.com.xk.qn.qnplatfrom.service.LinkService;
import com.com.xk.qn.qnplatfrom.utils.UuidUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: spring-security-demo
 * @description: 链接信息接口实现
 * @author: TianXiaoKang
 * @create: 2020-09-21 17:41
 **/
@Service
public class LinkServiceImpl  extends ServiceImpl<LinkMapper,Link> implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private LinkTypeMapper linkTypeMapper;

    @Override
    public List<LinkVO> selectAllLinkInfo() {
        List<LinkDTO> linkList = linkMapper.selectAll();
        linkList.sort(Comparator.comparing(LinkDTO::getTypeOrder).reversed());
        List<LinkVO> linkVOList = new ArrayList<>();
        Map<String,LinkVO> linkVOMap = new HashMap<>();
        linkList.stream().forEach(link ->{
            if (null != linkVOMap.get(link.getTypeId())){
                return;
            }
            LinkVO linkVO = new LinkVO();
            linkVO.setTypeName(link.getTypeName());
            linkVO.setTypeOrder(link.getTypeOrder());
            List<Link> linkList1 = new ArrayList<>();
            linkList.stream().forEach(link2 ->{
                if (StringUtils.equals(link2.getTypeId(),link.getTypeId())){
                    Link link1 = new Link();
                    BeanUtils.copyProperties(link2,link1);
                    if (StringUtils.equals(link1.getState(), "1")) {
                        link1.setState("有效");
                    } else {
                        link1.setState("无效");
                    }
                    link1.setId(link2.getLinkId());
                    linkList1.add(link1);
                }
            });
            linkList1.sort(Comparator.comparing(Link::getLinkOrder).reversed());
            linkVO.setLinkList(linkList1);
            linkVOMap.put(link.getTypeId(),linkVO);
            linkVOList.add(linkVO);
        });
        return linkVOList;
    }

    @Override
    public List<LinkType> selectAllLinkType() {
        return linkTypeMapper.selectList(new QueryWrapper<LinkType>().lambda().eq(LinkType::getState,"1").orderByAsc(LinkType::getTypeOrder));
    }

    @Override
    public void addLinkType(String typeName, String order) {
        LinkType linkType = new LinkType();
        linkType.setState("1");
        System.out.println(UuidUtils.getUUID());
        linkType.setTypeName(typeName);
        linkType.setTypeOrder(order);
        linkType.setCreatedTime(new Date());
        linkTypeMapper.insert(linkType);
    }

    @Override
    public void addLink(LinkFileVo linkFileVo, String imagePath) {
        Link link = new Link();
        link.setId(UuidUtils.getUUID());
        link.setState("1");
        link.setCreatedTime(new Date());
        link.setLinkImage(imagePath);
        link.setLinkName(linkFileVo.getLinkName());
        link.setLinkOrder(linkFileVo.getLinkOrder());
        link.setLinkUrl(linkFileVo.getLinkUrl());
        link.setLinkType(linkFileVo.getLinkType());
        linkMapper.insert(link);
    }
}