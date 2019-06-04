package com.yibao.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDO {

    /**
     * 自增ID
     */
    private Integer id;

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
     * 创建人,0表示无创建人值
     */
    private Integer creator;

    /**
     * 修改人,如果为0则表示纪录未修改
     */
    private Integer modifier;

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
     * 医院类别（1:综合 2:专科）
     */
    private Integer hospitalType;

    /**
     * 医院介绍
     */
    private String hospitalDescription;

}
