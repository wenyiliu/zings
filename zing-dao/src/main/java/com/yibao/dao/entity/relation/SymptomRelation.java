package com.yibao.dao.entity.relation;

import com.yibao.dao.entity.Disease;
import com.yibao.dao.entity.node.Symptom;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @auther: liuwenyi
 * @date 2019/5/13 15:15
 */
@Data
@RelationshipEntity(type = "症状")
public class SymptomRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Disease disease;

    @EndNode
    private Symptom symptom;

    public SymptomRelation() {
    }

}
