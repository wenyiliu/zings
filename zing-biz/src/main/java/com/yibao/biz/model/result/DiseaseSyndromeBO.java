package com.yibao.biz.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/17 17:00
 */
@Data
@ApiModel("疾病对应的并发症，一对多")
public class DiseaseSyndromeBO {

    @ApiModelProperty(value = "疾病名称")
    private String disName;

    @ApiModelProperty(value = "并发症")
    private List<DiseaseBO> syndromeList;

}
