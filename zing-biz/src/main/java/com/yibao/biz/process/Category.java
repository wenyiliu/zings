package com.yibao.biz.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @auther: liuwenyi
 * @date 2019/5/17 17:44
 */
@Data
@ApiModel("样本分类数据")
public class Category {

    @ApiModelProperty(value = "类别索引", example = "1.0")
    private Double index;

    @ApiModelProperty(value = "该类别在样本空间的概率", example = "0.314159262")
    private Double probability;

    @ApiModelProperty(value = "特征空间对应的特征的取值的概率")
    private List<Map<Double, Double>> feature;

}
