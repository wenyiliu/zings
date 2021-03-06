package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Drug;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuwenyi
 * @date 2019/5/12 15:58
 */
@Repository
public interface DrugRepository extends Neo4jRepository<Drug, Long> {
}
