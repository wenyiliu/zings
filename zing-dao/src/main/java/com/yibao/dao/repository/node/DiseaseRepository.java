package com.yibao.dao.repository.node;

import com.yibao.dao.entity.Disease;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/4/30 17:46
 */
@Repository
public interface DiseaseRepository extends Neo4jRepository<Disease, Long> {

    /**
     * 根据疾病名称获取疾病详情
     * @param dName
     * @return
     */
    List<Disease> getDiseaseByName(@Param("dName") String dName);

    /**
     * 根据疾病名称获取相关并发症
     * @param getSyn
     * @return
     */
    @Query("match(n:Disease)-[:并发症]->(m:Disease) where n.name={getSyn} return m")
    List<Disease> getSyndromeByDiseaseName(@Param("getSyn") String getSyn);

    /**
     * 根据疾病名称获取疾病相关药物
     * @param getDrug
     * @return
     */
    @Query("match(n:Disease)-[:常用药品|好评药品]->(m:Drug) where n.name={getDrug} return m.name")
    List<String> getDrugByDiseaseName(@Param("getDrug") String getDrug);

    /**
     * 根据疾病名称获取疾病所属科室
     * @param getDepart
     * @return
     */
    @Query("match(n:Disease)-[:所属科室]->(m:Department) where n.name={getDepart} return m.name")
    List<String> getDepartmentByDiseaseName(@Param("getDepart") String getDepart);

}
