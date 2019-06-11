package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.CheckRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/14 10:39
 */
@Repository
public interface CheckRelationRepository extends Neo4jRepository<CheckRelation, Long> {

    /**
     * 根据疾病名称获取相关检查
     *
     * @param disName
     * @return
     */
    @Query("match p=(d:Disease)-[:诊断检查]->(c:Check) where d.name={disName} return p")
    List<CheckRelation> getCheckRelationByDisName(@Param("disName") String disName);
}
