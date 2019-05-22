package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/13 17:40
 */
@Data
@ApiModel("症状导致的疾病，一对多")
public class SymptomDiseaseBO {

    @ApiModelProperty(value = "症状名称", example = "打鼾")
    private String symName;

    @ApiModelProperty(value = "与症状相关的疾病", example = "鼾症")
    private List<DiseaseBO> diseaseList;

}
