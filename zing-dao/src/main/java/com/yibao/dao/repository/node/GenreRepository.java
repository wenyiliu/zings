package com.yibao.dao.repository.node;

import com.yibao.dao.entity.node.Genre;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuwenyi
 * @date 2019/5/29 10:24
 */
@Repository
public interface GenreRepository extends Neo4jRepository<Genre,Long> {
}
