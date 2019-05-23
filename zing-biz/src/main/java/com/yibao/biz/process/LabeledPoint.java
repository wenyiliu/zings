package com.yibao.biz.process;

import lombok.Data;

/**
 * @auther: liuwenyi
 * @date 2019/5/17 17:43
 */
@Data
public class LabeledPoint {

    private Double label;

    private double[] data;

    public LabeledPoint() {

    }

    public LabeledPoint(Double label, double[] data) {
        this.label = label;
        this.data = data;
    }
}
