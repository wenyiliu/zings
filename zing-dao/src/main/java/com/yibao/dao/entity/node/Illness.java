package com.yibao.dao.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author liuwenyi
 * @date 2019/5/29 11:02
 */
@Data
@NodeEntity
public class Illness {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String aliaso;

    private String aliast;
}
