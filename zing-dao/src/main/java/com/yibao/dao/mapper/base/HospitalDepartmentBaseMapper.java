package com.yibao.dao.mapper.base;

import com.yibao.dao.entity.HospitalDepartmentDO;
import com.yibao.dao.entity.param.HospitalDepartmentConditionBuilder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Repository
public interface HospitalDepartmentBaseMapper {

    /**
     * 插入（匹配有值的字段）
     *
     * @param record HospitalDepartmentDO
     * @return int
     */
    int insertSelective(HospitalDepartmentDO record);

    /**
     * 批量插入
     *
     * @param recordList List<HospitalDepartmentDO>
     * @return int
     */
    int batchInsert(@Param("recordList") List<HospitalDepartmentDO> recordList);

    /**
     * 根据主键ID更新（匹配有值的字段）
     *
     * @param record HospitalDepartmentDO
     * @return int
     */
    int updateById(HospitalDepartmentDO record);

    /**
     * 批量更新（匹配有值的字段）
     *
     * @param recordList List<HospitalDepartmentDO>
     * @return int
     */
    int batchUpdateById(@Param("recordList") List<HospitalDepartmentDO> recordList);

    /**
     * 动态条件查询（匹配有值的字段）
     *
     * @param params 筛选条件
     * @return List<HospitalDepartmentDO>
     */
    List<HospitalDepartmentDO> selectByCondition(HospitalDepartmentConditionBuilder params);

    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return HospitalDepartmentDO
     */
    HospitalDepartmentDO selectById(@Param("id") Integer id);
}