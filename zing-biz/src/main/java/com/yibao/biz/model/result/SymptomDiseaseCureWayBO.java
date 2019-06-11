package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/22 16:15
 */
@Data
@ApiModel("症状的治疗方式，一对多对多")
public class SymptomDiseaseCureWayBO {

    @ApiModelProperty(value = "症状名称")
    private String symName;

    @ApiModelProperty(value = "症状所对应的疾病名称以及治疗方式")
    private List<DiseaseCureWayBO> diseaseCureWayList;

}
