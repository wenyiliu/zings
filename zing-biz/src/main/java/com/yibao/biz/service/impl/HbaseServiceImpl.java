package com.yibao.biz.service.impl;

import com.yibao.biz.service.HbaseService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author liuwenyi
 * @date 2019/07/01
 */
@Service
public class HbaseServiceImpl implements HbaseService {

    @Value("${hbase.zookeeper.quorum}")
    private static String zQuorum;

    @Value("${hbase.property.clientPort}")
    private static String port;

    @Override
    public Connection getConnection() {
        Connection connection=null;
        Configuration configuration=new Configuration();
        configuration.set("hbase.zookeeper.quorum", zQuorum);
        configuration.set("hbase.zookeeper.property.clientPort",port);
        try {
            connection= ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
