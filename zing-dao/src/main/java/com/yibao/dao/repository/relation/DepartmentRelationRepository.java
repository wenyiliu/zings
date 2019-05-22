package com.yibao.dao.repository.relation;

import com.yibao.dao.eneity.relation.DepartmentRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 15:22
 */
@Repository
public interface DepartmentRelationRepository extends Neo4jRepository<DepartmentRelation, Long> {

    /**
     * 根据疾病名称获取相关科室
     *
     * @param disName
     * @return
     */
    @Query("match p=(n:Disease)-[:所属科室]->(m:Department) where n.name={disName} return p")
    List<DepartmentRelation> getDepartmentRelationByDisName(@Param("disName") String disName);
}
