package com.yibao.dao.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 10:22
 */
@Data
@NodeEntity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String cause;

    private String characteristic;

    private String type;

    public Genre(){

    }
}
