package com.yibao.common.util;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author liuwenyi
 * @date 2019/07/01
 */
@Component
public class HBaseUtils {

    private static Connection connection = null;
    private static Configuration conf = HBaseConfiguration.create();

    @Value("${hbase.zookeeper.quorum}")
    private static String zQuorum;

    @Value("${hbase.property.clientPort}")
    private static String port;

    public  Connection getConnection() {
        System.out.println(zQuorum);
        System.out.println(port);
        conf.set("hbase.zookeeper.quorum", zQuorum);
        conf.set("hbase.zookeeper.property.clientPort",port);
        try {
            connection= ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
