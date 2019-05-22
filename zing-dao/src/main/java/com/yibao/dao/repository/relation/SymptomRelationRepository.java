package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.node.Symptom;
import com.yibao.dao.entity.relation.SymptomRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/13 15:19
 */
@Repository
public interface SymptomRelationRepository extends Neo4jRepository<Symptom, Long> {

    /**
     * 根据症状名称获取相关疾病
     *
     * @param symName
     * @return
     */
    @Query("match p=(d:Disease)-[:症状]->(s:Symptom) where s.name={symName} return p")
    List<SymptomRelation> getDiseaseBySymptomName(@Param("symName") String symName);

    /**
     * 根据疾病名称获取相关症状
     * @param disName
     * @return
     */
    @Query("match p=(d:Disease)-[:症状]->(s:Symptom) where d.name={disName} return p")
    List<SymptomRelation> getSymptomByDisName(@Param("disName") String disName);
}
