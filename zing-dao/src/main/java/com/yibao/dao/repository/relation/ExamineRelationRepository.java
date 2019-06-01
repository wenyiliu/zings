package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.ExamineRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 11:32
 */
@Repository
public interface ExamineRelationRepository extends Neo4jRepository<ExamineRelation,Long>{
}
