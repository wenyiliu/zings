package com.yibao.dao.repository.node;

import com.yibao.dao.eneity.node.Department;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 18:11
 */
@Repository
public interface DepartmentRepository extends Neo4jRepository<Department, Long> {
}
