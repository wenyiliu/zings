package com.yibao.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuwenyi
 * @date 2019/5/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataCenterResultDO {

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
     * 数据中心统计查询SQL表`yb_data_center_sql`主键
     */
    private Integer sqlId;

    /**
     * 统计日期
     */
    private java.time.LocalDate statisticalDate;

    /**
     * 以json形式存储数据统计结果
     */
    private String statisticalResult;

}
