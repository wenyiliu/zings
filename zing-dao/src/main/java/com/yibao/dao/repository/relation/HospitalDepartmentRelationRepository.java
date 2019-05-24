package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.HospitalDepartmentRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liuwenyi
 * @date 2019/5/24 14:46
 */
@Repository
public interface HospitalDepartmentRelationRepository extends Neo4jRepository<HospitalDepartmentRelation,Long>{


}
