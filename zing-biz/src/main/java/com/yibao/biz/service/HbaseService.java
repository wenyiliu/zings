package com.yibao.biz.service;

import org.apache.hadoop.hbase.client.Connection;

/**
 * @author liuwenyi
 * @date 2019/07/01
 */
public interface HbaseService {

    Connection getConnection();
}
