package com.yibao.dao.mapper.base;

import com.yibao.dao.entity.HospitalDO;
import com.yibao.dao.entity.param.HospitalConditionBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Repository
public interface HospitalBaseMapper {

    /**
     * 插入（匹配有值的字段）
     *
     * @param record HospitalDO
     * @return int
     */
    int insertSelective(HospitalDO record);

    /**
     * 批量插入
     *
     * @param recordList List<HospitalDO>
     * @return int
     */
    int batchInsert(@Param("recordList") List<HospitalDO> recordList);

    /**
     * 根据主键ID更新（匹配有值的字段）
     *
     * @param record HospitalDO
     * @return int
     */
    int updateById(HospitalDO record);

    /**
     * 批量更新（匹配有值的字段）
     *
     * @param recordList List<HospitalDO>
     * @return int
     */
    int batchUpdateById(@Param("recordList") List<HospitalDO> recordList);

    /**
     * 动态条件查询（匹配有值的字段）
     *
     * @param params 筛选条件
     * @return List<HospitalDO>
     */
    List<HospitalDO> selectByCondition(HospitalConditionBuilder params);

    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return HospitalDO
     */
    HospitalDO selectById(@Param("id") Integer id);
}