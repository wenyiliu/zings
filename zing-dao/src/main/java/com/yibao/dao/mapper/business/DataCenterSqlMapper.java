package com.yibao.dao.mapper.business;

import com.yibao.dao.entity.DataCenterSqlDO;
import com.yibao.dao.mapper.base.DataCenterSqlBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author liuwenyi
 * @date 2019/6/4
 */
@Repository
public interface DataCenterSqlMapper extends DataCenterSqlBaseMapper {

    /**
     * 动态查询sql
     * @param map
     * @return
     */
    List<DataCenterSqlDO> selectByBaseCondition(Map<String,Object> map);

    /**
     * 执行SQL语句
     * @param sql
     * @return
     */
    List<Map<String,Object>> executeSql(@Param("sql") String sql);
}