package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 15:57
 */
@Data
@ApiModel("疾病与防御措施，一对一")
public class DiseasePreventBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "疾病防御措施")
    private String prevent;

}
