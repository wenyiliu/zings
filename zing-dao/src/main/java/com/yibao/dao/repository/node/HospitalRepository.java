package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Hospital;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/14 19:48
 */
@Repository
public interface HospitalRepository extends Neo4jRepository<Hospital, Long> {

    /**
     * 根据名字获取医院
     * @param name
     * @return
     */
    @Query("match(n:Hospital) where n.name={name} or n.alias={name} return n")
    List<Hospital> getDistinctByNameOrAlias(@Param("name") String name);
}
