package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Illness;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liuwenyi
 * @date 2019/5/29 11:11
 */
@Repository
public interface IllnessRepository extends Neo4jRepository<Illness, Long> {

    /**
     * 获取疾病
     *
     * @param name 疾病名称
     * @return Illness
     */
    @Query("match(n:Illness) where n.name={name} or n.aliaso={name} or n.aliast={name} return n")
    Illness findIllnessByName(@Param("name") String name);
}
