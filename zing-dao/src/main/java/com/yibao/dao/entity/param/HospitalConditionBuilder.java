package com.yibao.dao.entity.param;

import lombok.Builder;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Builder
public class HospitalConditionBuilder {

    /**
     * 自增ID
     */
    private Integer id;

    /**
     * id的List条件
     */
    private List<Integer> idList;

    /**
     * 是否删除（0:未删除 1:已删除）
     */
    private Integer isDeleted;

    /**
     * 记录创建时间
     */
    private java.time.LocalDateTime createTime;

    /**
     * 记录修改时间
     */
    private java.time.LocalDateTime modifyTime;

    /**
     * 医院全称
     */
    private String hospitalName;

    /**
     * 医院简称
     */
    private String hospitalAlias;

    /**
     * 医院级别（1:三级甲等 2:三级合格 3:二级甲等 4:二级合格 5:一级 6:社区卫生服务站 7:诊所 8:其他 9:民营）
     */
    private Integer hospitalLevel;

    /**
     * hospitalLevel的List条件
     */
    private List<Integer> hospitalLevelList;

    /**
     * 医院类别（1:综合 2:专科）
     */
    private Integer hospitalType;

    /**
     * hospitalType的List条件
     */
    private List<Integer> hospitalTypeList;

    /**
     * 医院介绍
     */
    private String hospitalDescription;

}
