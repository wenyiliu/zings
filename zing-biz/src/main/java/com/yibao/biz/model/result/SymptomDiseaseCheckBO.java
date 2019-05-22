package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 17:14
 */
@Data
@ApiModel("症状对应的疾病以及疾病对应的检查，一对多对多")
public class SymptomDiseaseCheckBO {

    @ApiModelProperty(value = "症状名称")
    private String symName;

    @ApiModelProperty(value = "疾病和检查")
    private List<DiseaseCheckBO> diseaseCheckList;

}
