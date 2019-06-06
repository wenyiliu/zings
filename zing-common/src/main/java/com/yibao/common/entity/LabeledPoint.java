package com.yibao.common.entity;

import lombok.Data;

/**
 * @auther: liuwenyi
 * @date 2019/5/17 17:43
 */
@Data
public class LabeledPoint {

    private Integer label;

    private double[] data;

    public LabeledPoint() {

    }

    public LabeledPoint(Integer label, double[] data) {
        this.label = label;
        this.data = data;
    }
}
