package com.yibao.dao.mapper.base;

import com.yibao.dao.entity.DataCenterResultDO;
import com.yibao.dao.entity.param.DataCenterResultConditionBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/21
 */
@Repository
public interface DataCenterResultBaseMapper {

    /**
     * 插入（匹配有值的字段）
     *
     * @param record DataCenterResultDO
     * @return int
     */
    int insertSelective(DataCenterResultDO record);

    /**
     * 批量插入
     *
     * @param recordList List<DataCenterResultDO>
     * @return int
     */
    int batchInsert(@Param("recordList") List<DataCenterResultDO> recordList);

    /**
     * 根据主键ID更新（匹配有值的字段）
     *
     * @param record DataCenterResultDO
     * @return int
     */
    int updateById(DataCenterResultDO record);

    /**
     * 批量更新（匹配有值的字段）
     *
     * @param recordList List<DataCenterResultDO>
     * @return int
     */
    int batchUpdateById(@Param("recordList") List<DataCenterResultDO> recordList);

    /**
     * 动态条件查询（匹配有值的字段）
     *
     * @param params 筛选条件
     * @return List<DataCenterResultDO>
     */
    List<DataCenterResultDO> selectByCondition(DataCenterResultConditionBuilder params);

    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return DataCenterResultDO
     */
    DataCenterResultDO selectById(@Param("id") Integer id);
}