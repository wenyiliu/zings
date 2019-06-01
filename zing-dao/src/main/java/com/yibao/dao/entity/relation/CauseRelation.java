package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Cause;
import com.yibao.dao.entity.node.Illness;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:07
 */
@Data
@RelationshipEntity(type = "诱因")
public class CauseRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Illness startNode;

    @EndNode
    private Cause endNode;

    public CauseRelation(){

    }
}
