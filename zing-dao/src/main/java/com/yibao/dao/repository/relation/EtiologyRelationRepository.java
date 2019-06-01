package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.EtiologyRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:31
 */
@Repository
public interface EtiologyRelationRepository extends Neo4jRepository<EtiologyRelation,Long> {
}
