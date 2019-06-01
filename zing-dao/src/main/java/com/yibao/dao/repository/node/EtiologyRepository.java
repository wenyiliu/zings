package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Etiology;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:30
 */
@Repository
public interface EtiologyRepository extends Neo4jRepository<Etiology,Long>{
}
