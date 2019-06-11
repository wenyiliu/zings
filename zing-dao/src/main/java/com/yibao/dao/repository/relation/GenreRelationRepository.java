package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.GenreRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuwenyi
 * @date 2019/5/29 11:09
 */
@Repository
public interface GenreRelationRepository extends Neo4jRepository<GenreRelation,Long> {

}
