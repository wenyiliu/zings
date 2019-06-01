package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Examine;
import com.yibao.dao.entity.node.Illness;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 11:28
 */
@Data
@RelationshipEntity(type = "常用检查")
public class ExamineRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Illness startNode;

    @EndNode
    private Examine endNode;

    public ExamineRelation(){}
}
