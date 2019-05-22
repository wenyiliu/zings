package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/13 17:49
 */
@Data
@ApiModel("疾病详情，一对多")
public class DiseaseBO {

    @ApiModelProperty(value = "疾病名", example = "鼾症")
    private String disName;

    @ApiModelProperty(value = "疾病所属科室", example = "呼吸科")
    private List<String> department;

}
