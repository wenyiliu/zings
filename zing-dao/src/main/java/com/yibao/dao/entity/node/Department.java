package com.yibao.dao.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 15:25
 */
@Data
@NodeEntity(label = "Department")
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String level;

    public Department() {
    }
}
