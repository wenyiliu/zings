package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.node.Department;
import com.yibao.dao.entity.node.Hospital;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @author liuwenyi
 * @date 2019/5/24 14:40
 */
@Data
@RelationshipEntity("医院科室")
public class HospitalDepartmentRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Hospital startNode;

    @EndNode
    private Department endNode;

    public HospitalDepartmentRelation() {

    }

    public HospitalDepartmentRelation(Hospital startNode, Department endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }
}
