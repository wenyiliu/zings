package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Examine;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 11:31
 */
@Repository
public interface ExamineRepository extends Neo4jRepository<Examine,Long> {
}
