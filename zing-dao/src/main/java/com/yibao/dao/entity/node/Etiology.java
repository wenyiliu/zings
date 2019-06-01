package com.yibao.dao.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 14:26
 * 心衰基本病因
 */
@Data
@NodeEntity
public class Etiology {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String desc;

    private String type;

    public Etiology(){

    }

}
