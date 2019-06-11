package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/14 16:01
 */
@Data
@ApiModel("疾病和治疗方式，一对多")
public class DiseaseCureWayBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "治疗方式")
    private List<String> cureWayList;

}
