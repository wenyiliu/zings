package com.yibao.dao.repository.node;

import com.yibao.dao.eneity.node.Hospital;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 19:48
 */
@Repository
public interface HospitalRepository extends Neo4jRepository<Hospital, Long> {

    @Query("match(n:Hospital) where n.name={name} or n.alias={name} return n")
    List<Hospital> getDistinctByNameOrAlias(@Param("name") String name);
}
