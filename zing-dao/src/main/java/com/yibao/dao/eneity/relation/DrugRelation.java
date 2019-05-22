package com.yibao.dao.eneity.relation;

import com.yibao.dao.eneity.Disease;
import com.yibao.dao.eneity.node.Drug;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/12 14:56
 */
@Data
@RelationshipEntity(type = "常用药品")
public class DrugRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Disease disease;

    @EndNode
    private Drug drug;

    private String relation;

    public DrugRelation() {

    }
}
