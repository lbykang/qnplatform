package com.com.xk.qn.qnplatfrom.controller;

import com.com.xk.qn.qnplatfrom.entity.Link;
import com.com.xk.qn.qnplatfrom.entity.LinkType;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkFileVo;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkInfoVO;
import com.com.xk.qn.qnplatfrom.entity.vo.LinkVO;
import com.com.xk.qn.qnplatfrom.mapper.LinkMapper;
import com.com.xk.qn.qnplatfrom.result.ResultCode;
import com.com.xk.qn.qnplatfrom.result.ResultJson;
import com.com.xk.qn.qnplatfrom.service.LinkService;
import com.com.xk.qn.qnplatfrom.service.serviceImp.LinkServiceImpl;
import com.com.xk.qn.qnplatfrom.utils.MinioUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @program: spring-security-demo
 * @description: 首页链接信息
 * @author: TianXiaoKang
 * @create: 2020-09-21 17:31
 **/
@RestController
@RequestMapping("/link")
@Slf4j
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private LinkMapper linkMapper;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.port}")
    private int port;

    @Value("${minio.bucketName}")
    private String bucketName;


    @GetMapping("/getLink")
    @ResponseBody
    public List<LinkVO> selectAllLinkInfo(){
       return linkService.selectAllLinkInfo();
    }

    @GetMapping("/getLinkById")
    @ResponseBody
    public LinkInfoVO selectAllLinkInfoById(String id){
        return linkMapper.selectLinkById(id);
    }

    @GetMapping("/getLinkType")
    @ResponseBody
    public List<LinkType> selectAllType(){
        return linkService.selectAllLinkType();
    }

    @PostMapping("/addLinkType")
    @ResponseBody
    public ResultJson addLinkType(@RequestParam(value="typeName")String typeName,@RequestParam(value="order")String order){
        linkService.addLinkType(typeName,order);
        return new ResultJson(ResultCode.SUCCESS);
    }

    @PostMapping("/addLink")
    @ResponseBody
    public ResultJson addLinkType(LinkFileVo linkFileVo){
        String imagePath = upload(linkFileVo.getPcFile());
        linkService.addLink(linkFileVo,imagePath);
        return new ResultJson(ResultCode.SUCCESS);
    }


    @SneakyThrows
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        log.info("上传成功");
        minioUtil.putObject("picture",file,file.getOriginalFilename());
        return "http://"+endpoint+":"+port+"/"+bucketName+"/"+file.getOriginalFilename();
    }
}