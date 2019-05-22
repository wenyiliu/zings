package com.yibao.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @auther: liuwenyi
 * @date 2019/5/21 14:58
 */
@SpringBootApplication(scanBasePackages ="com.yibao")
@MapperScan("com.yibao.dao.mapper")
@EntityScan("com.yibao.dao.eneity")
@EnableNeo4jRepositories("com.yibao.dao.repository")
public class ZingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZingApplication.class,args);
    }
}
