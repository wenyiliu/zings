package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 16:07
 */
@Data
@ApiModel("疾病和疾病简介，一对一")
public class DiseaseDescBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "疾病简介")
    private String desc;

}
