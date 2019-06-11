package com.yibao.biz.model;

import lombok.Data;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/13 20:12
 */
@Data
public class Answer {

    /**
     * 分类索引
     */
    private Double index;

    /**
     * 关键词
     */
    private List<String> values;

}
