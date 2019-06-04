package com.yibao.dao.entity.param;

import lombok.Builder;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/6/4
 */
@Builder
public class DataCenterSqlConditionBuilder {

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
     * sql功能描述
     */
    private String functionName;

    /**
     * sql语句
     */
    private String functionSql;

}
