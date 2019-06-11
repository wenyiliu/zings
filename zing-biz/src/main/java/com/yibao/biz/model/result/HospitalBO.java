package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuwenyi
 * @date 2019/5/20 16:16
 */
@Data
@ApiModel("医院")
public class HospitalBO {

    @ApiModelProperty(value = "医院名称")
    private String name;

    @ApiModelProperty(value = "医院简称")
    private String alias;

    @ApiModelProperty(value = "医院地址")
    private String address;

    @ApiModelProperty(value = "医院简介")
    private String desc;

}
