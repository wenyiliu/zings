package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.CauseRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuwenyi
 * @date 2019/5/29 14:10
 */
@Repository
public interface CauseRelationRepository extends Neo4jRepository<CauseRelation,Long> {

}
