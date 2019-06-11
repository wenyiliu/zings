package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Department;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/14 18:11
 */
@Repository
public interface DepartmentRepository extends Neo4jRepository<Department, Long> {

    /**
     * 获取科室
     * @param depName
     * @return
     */
    @Query("match (n:Department) where n.name={depName} return n")
    List<Department> getDepartmentByName(@Param("depName") String depName);
}
