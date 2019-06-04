package com.yibao.dao.entity.param;

import lombok.Builder;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Builder
public class HospitalDepartmentConditionBuilder {

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
     * 医院ID
     */
    private Integer hospitalId;

    /**
     * hospitalId的List条件
     */
    private List<Integer> hospitalIdList;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室级别（1:普通科室 2:重点科室）
     */
    private Integer departmentLevel;

    /**
     * departmentLevel的List条件
     */
    private List<Integer> departmentLevelList;

}
