package com.yibao.dao.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author liuwenyi
 * @date 2019/5/10 16:27
 */
@Data
@NodeEntity(label = "Check")
public class Check {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Check() {
    }
}
