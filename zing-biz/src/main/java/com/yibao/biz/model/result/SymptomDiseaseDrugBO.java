package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/13 17:44
 */
@Data
@ApiModel("症状对应的疾病以及疾病对应的药物，一对多对多")
public class SymptomDiseaseDrugBO {

    @ApiModelProperty(value = "症状名称")
    private String symName;

    @ApiModelProperty(value = "疾病和药物")
    private List<DiseaseDrugBO> diseaseDrugList;

}
