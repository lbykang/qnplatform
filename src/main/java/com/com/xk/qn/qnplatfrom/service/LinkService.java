package com.com.xk.qn.qnplatfrom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.com.xk.qn.qnplatfrom.entity.Link;
import com.com.xk.qn.qnplatfrom.entity.LinkType;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkFileVo;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkVO;

import java.util.List;

public interface LinkService extends IService<Link> {

    /**查询所有链接信息
     * @return
     */
    List<LinkVO> selectAllLinkInfo();

    /**查询所有链接类型
     * @return
     */
    List<LinkType> selectAllLinkType();

    void addLinkType(String typeName, String order);

    void addLink(LinkFileVo linkFileVo, String imagePath);


}
