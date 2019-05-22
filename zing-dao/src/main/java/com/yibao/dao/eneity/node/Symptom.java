package com.yibao.dao.eneity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @auther: liuwenyi
 * @date 2019/5/10 14:00
 */
@Data
@NodeEntity(label = "Symptom")
public class Symptom {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Symptom() {

    }
}
