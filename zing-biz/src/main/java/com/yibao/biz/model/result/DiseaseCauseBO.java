package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuwenyi
 * @date 2019/5/14 15:45
 */
@Data
@ApiModel("疾病诱因，一对一")
public class DiseaseCauseBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "疾病诱因")
    private String cause;

}
