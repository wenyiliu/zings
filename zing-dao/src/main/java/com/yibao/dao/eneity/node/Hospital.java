package com.yibao.dao.eneity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 18:29
 */
@Data
@NodeEntity(label = "Hospital")
public class Hospital {

    @Id
    @GeneratedValue
    private Long id;

    private Integer pId;

    private String name;

    private String alias;

    private String address;

    private String desc;

    public Hospital() {

    }
}
