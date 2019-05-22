package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 11:42
 */
@Data
@ApiModel("疾病相关的症状，一对多")
public class DiseaseSymptomBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "疾病对应的症状")
    private List<String> symptomList;

}
