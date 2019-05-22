package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 10:58
 */
@Data
@ApiModel("疾病和相关检查，一对多")
public class DiseaseCheckBO {

    @ApiModelProperty(value = "疾病名称", example = "鼾症")
    private String disName;

    @ApiModelProperty(value = "疾病对应的检查", example = "[呼吸科,血液检查]")
    private List<String> checkList;

}
