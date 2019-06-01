package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Genre;
import com.yibao.dao.entity.node.Illness;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 10:56
 */
@Data
@RelationshipEntity(type = "类型")
public class GenreRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Illness startNode;

    @EndNode
    private Genre endNode;
}
