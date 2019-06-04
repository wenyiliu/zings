package com.yibao.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwenyi
 * @date 2019/6/4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataCenterSqlDO {

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
     * sql功能描述
     */
    private String functionName;

    /**
     * sql语句
     */
    private String functionSql;

}
