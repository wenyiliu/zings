package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liuwenyi
 * @date 2019/5/28 15:04
 */
@Data
@ApiModel("邮件服务")
public class MailBO implements Serializable{

    @ApiModelProperty(value = "接收者")
    private String[] recipient;

    @ApiModelProperty(value = "邮件主题",example = "数据中心")
    private String subject;

    @ApiModelProperty(value = "邮件内容")
    private String content;
}
