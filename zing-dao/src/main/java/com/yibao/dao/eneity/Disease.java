package com.yibao.dao.eneity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/4/30 17:42
 * 字段名要与neo4j中的字段名一一对应
 */
@Data
@NodeEntity
public class Disease {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 疾病名称
     */
    private String name;

    /**
     * 疾病的防御措施
     */
    private String prevent;

    /**
     * 疾病的治愈概率
     */
    private String cured_prob;

    /**
     * 疾病诱因
     */
    private String cause;

    /**
     * 疾病的治疗方式
     */
    private List<String> cure_way;

    /**
     * 疾病的持续时间
     */
    private String cure_lasttime;

    /**
     * 治疗疾病科室
     */
    private List<String> cure_department;

    /**
     * 疾病描述
     */
    private String desc;


    public Disease() {

    }
}
