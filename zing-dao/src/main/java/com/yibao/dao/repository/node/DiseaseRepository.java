package com.yibao.dao.repository.node;

import com.yibao.dao.eneity.Disease;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/4/30 17:46
 */
@Repository
public interface DiseaseRepository extends Neo4jRepository<Disease, Long> {

    List<Disease> getDiseaseByName(@Param("dName") String dName);

    @Query("match(n:Disease)-[:并发症]->(m:Disease) where n.name={getSyn} return m")
    List<Disease> getSyndromeByDiseaseName(@Param("getSyn") String getSyn);

    @Query("match(n:Disease) where n.name={getCause} return n.cause")
    List<String> getCauseDiseaseName(@Param("getCause") String getCause);


    @Query("match(n:Disease)-[:常用药品|好评药品]->(m:Drug) where n.name={getDrug} return m.name")
    List<String> getDrugByDiseaseName(@Param("getDrug") String getDrug);

    @Query("match(n:Disease)-[:所属科室]->(m:Department) where n.name={getDepart} return m.name")
    List<String> getDepartmentByDiseaseName(@Param("getDepart") String getDepart);

}
