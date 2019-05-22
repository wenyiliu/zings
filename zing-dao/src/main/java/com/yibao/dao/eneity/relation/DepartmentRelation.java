package com.yibao.dao.eneity.relation;

import com.yibao.dao.eneity.node.Department;
import com.yibao.dao.eneity.Disease;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 15:23
 */
@Data
@RelationshipEntity(type = "所属科室")
public class DepartmentRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Disease startNode;

    @EndNode
    private Department endNode;

    public DepartmentRelation() {

    }
}
