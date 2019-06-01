package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Cause;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:09
 */
@Repository
public interface CauseRepository extends Neo4jRepository<Cause,Long> {
}
