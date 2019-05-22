package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 11:17
 */
@Data
@ApiModel("疾病相关药物，一对多")
public class DiseaseDrugBO {

    @ApiModelProperty(value = "疾病名称", example = "鼾症")
    private String disName;

    @ApiModelProperty(value = "药品")
    private List<String> drugList;

}
