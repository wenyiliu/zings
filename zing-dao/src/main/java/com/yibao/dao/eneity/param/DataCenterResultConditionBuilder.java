package com.yibao.dao.eneity.param;

import lombok.Builder;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/21
 */
@Builder
public class DataCenterResultConditionBuilder {

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
     * 数据中心统计查询SQL表`yb_data_center_sql`主键
     */
    private Integer sqlId;

    /**
     * sqlId的List条件
     */
    private List<Integer> sqlIdList;

    /**
     * 统计日期
     */
    private java.time.LocalDate statisticalDate;

    /**
     * 以json形式存储数据统计结果
     */
    private String statisticalResult;

}
