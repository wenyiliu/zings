package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Check;
import com.yibao.dao.entity.Disease;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @author liuwenyi
 * @date 2019/5/14 10:37
 */
@Data
@RelationshipEntity(type = "诊断检查")
public class CheckRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Disease startNode;

    @EndNode
    private Check endNode;

    public CheckRelation() {
    }

}
