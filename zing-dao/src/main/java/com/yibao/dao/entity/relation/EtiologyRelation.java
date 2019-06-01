package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Etiology;
import com.yibao.dao.entity.node.Illness;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:28
 */
@Data
@RelationshipEntity(type = "基本病因")
public class EtiologyRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Illness startNode;

    @EndNode
    private Etiology endNode;

    public EtiologyRelation(){

    }
}
