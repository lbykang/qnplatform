package com.com.xk.qn.qnplatfrom.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @program: spring-security-demo
 * @description: 链接信息带图片文件Vo
 * @author: TianXiaoKang
 * @create: 2020-09-22 11:51
 **/
@Data
public class LinkFileVo  implements Serializable {

    /** 链接名称 */
    private String linkName;
    /** 链接排序id */
    private String linkOrder;
    /** 链接地址 */
    private String linkUrl;
    /** 链接类型 */
    private String linkType;
    /** 图片文件 */
    private MultipartFile pcFile;
}