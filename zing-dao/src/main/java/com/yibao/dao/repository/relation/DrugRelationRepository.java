package com.yibao.dao.repository.relation;

import com.yibao.dao.entity.relation.DrugRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/12 15:01
 */
@Repository
public interface DrugRelationRepository extends Neo4jRepository<DrugRelation, Long> {

    /**
     * 根据疾病名称获取相关常用药物
     *
     * @param name
     * @return
     */
    @Query("MATCH p=(n:Disease)-[:常用药品]->(m:Drug) WHERE n.name={name} RETURN p")
    List<DrugRelation> commonDrugList(@Param("name") String name);

}
