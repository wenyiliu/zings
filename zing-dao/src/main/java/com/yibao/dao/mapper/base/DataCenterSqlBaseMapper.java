package com.yibao.dao.mapper.base;

import com.yibao.dao.entity.DataCenterSqlDO;
import com.yibao.dao.entity.param.DataCenterSqlConditionBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/6/4
 */
@Repository
public interface DataCenterSqlBaseMapper {

    /**
     * 插入（匹配有值的字段）
     *
     * @param record DataCenterSqlDO
     * @return int
     */
    int insertSelective(DataCenterSqlDO record);

    /**
     * 批量插入
     *
     * @param recordList List<DataCenterSqlDO>
     * @return int
     */
    int batchInsert(@Param("recordList") List<DataCenterSqlDO> recordList);

    /**
     * 根据主键ID更新（匹配有值的字段）
     *
     * @param record DataCenterSqlDO
     * @return int
     */
    int updateById(DataCenterSqlDO record);

    /**
     * 批量更新（匹配有值的字段）
     *
     * @param recordList List<DataCenterSqlDO>
     * @return int
     */
    int batchUpdateById(@Param("recordList") List<DataCenterSqlDO> recordList);

    /**
     * 动态条件查询（匹配有值的字段）
     *
     * @param params 筛选条件
     * @return List<DataCenterSqlDO>
     */
    List<DataCenterSqlDO> selectByCondition(DataCenterSqlConditionBuilder params);

    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return DataCenterSqlDO
     */
    DataCenterSqlDO selectById(@Param("id") Integer id);
}