package com.yibao.common.util.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;

/**
 * @author liuwenyi
 * @date 2019/07/01
 */
@Slf4j
@Component
public class HBaseConnection {

    public static Connection connection;
    private static Admin admin;

    static {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "10.26.108.150,10.26.234.215,10.27.214.15");
        conf.set("hbase.zookeeper.property.clientPort", "2181");

        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            log.error("获取hbase连接失败，原因：{}", e.getCause());
        }
    }


    private static void close() {
        try {
            admin.close();
            if (connection != null) {
                connection.close();
            }
        } catch (IOException e) {
            log.error("关闭hbase连接失败,原因：{}", e);
        } finally {
            try {
                admin.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建表
     *
     * @param tableName        表名
     * @param columnFamilyList 列族，可以添加多个列族
     * @return Boolean
     */
    public static Boolean createTable(String tableName, List<String> columnFamilyList) {
        TableName name = TableName.valueOf(tableName);
        try {
            if (admin.tableExists(name)) {
                log.info("{}已经存在", tableName);
                return true;
            }
            HTableDescriptor descriptor = new HTableDescriptor(name);
            if (columnFamilyList.isEmpty()) {
                log.error("{}的列族不能为空", tableName);
                return false;
            }
            columnFamilyList.forEach(columnFamily -> descriptor.addFamily(new HColumnDescriptor(columnFamily)));
            admin.createTable(descriptor);
            return true;
        } catch (IOException e) {
            log.error("创建{}失败，原因：{}", tableName, e);
            e.printStackTrace();
            return false;
        } finally {
            close();
        }
    }

    /**
     * 单行单列族多列添加数据
     *
     * @param tableName 表名
     * @param rowKey    行健
     * @param cf        列族
     * @param dataMap   key value 数据
     * @return int
     */
    public static int insertRecords(String tableName, String rowKey, String cf, Map<String, Object> dataMap) {
        Put put = getPut(rowKey, cf, dataMap);
        if (Objects.isNull(put)) {
            return 0;
        }
        TableName name = TableName.valueOf(tableName);
        Table table = null;
        try {
            table = connection.getTable(name);
            table.put(put);
            return dataMap.size();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                Objects.requireNonNull(table).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            close();
        }
    }

    public static int batchInsert() {
        return 0;
    }

    public static ResultScanner getAllData(String tableName) {
        Table table = null;
        ResultScanner scanner;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            scan.setCaching(2000);
            scanner = table.getScanner(scan);
        } catch (IOException w) {
            log.error("加载数据异常");
            return null;
        } finally {
            try {
                table.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner(scanner);
        return scanner;
    }

    private static Put getPut(String rowKey, String cf, Map<String, Object> dataMap) {
        if (dataMap.isEmpty()) {
            log.error("数据不能为空");
            return null;
        }
        Put put = new Put(rowKey.getBytes());
        dataMap.forEach((key, value) -> put.addColumn(cf.getBytes(), key.getBytes(), value.toString().getBytes()));
        return put;
    }

    /**
     * 删除表
     *
     * @param tableName 表名
     * @return Boolean
     */
    public static Boolean deleteTable(String tableName) {
        TableName name = TableName.valueOf(tableName);
        try {
            if (admin.tableExists(name)) {
                admin.disableTable(name);
                admin.deleteTable(name);
            } else {
                log.error("表不存在");
            }
            return true;
        } catch (IOException e) {
            log.error("删除表：{}失败，原因：{}", tableName, e);
            return false;
        } finally {
            close();
        }

    }

    /**
     * 删除某一个字段
     *
     * @param tableName 表名
     * @param rowkey    行健
     * @param cf        列族
     * @param column    列
     * @return
     */
    public static Boolean deleteRecords(String tableName, String rowkey, String cf, String column) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            Delete delete = new Delete(rowkey.getBytes());
            delete.addColumn(cf.getBytes(), column.getBytes());
            table.delete(delete);
            return true;
        } catch (IOException e) {
            log.error("删除数据失败");
            return false;
        } finally {
            try {
                table.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            close();
        }
    }

    public static void valueFilterFuzzy(String tableName, String value) {
        Table table;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(value));
            Scan scan = new Scan();
            scan.setCaching(100);
            scan.setFilter(filter);
            ResultScanner scanner = table.getScanner(scan);
            scanner(scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private static ResultScanner filter(String tableName, String cf, String column, String value, CompareFilter.CompareOp compareOp, ByteArrayComparable comparable){
//        ResultScanner results=
//    }
    private static void scanner(ResultScanner scanner) {
        scanner.forEach(s -> {
            NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> navigableMap = s.getMap();
            for (byte[] family : navigableMap.keySet()) {
                System.out.println("列族:" + new String(family));
                for (byte[] column : navigableMap.get(family).keySet()) {
                    System.out.println("列:" + new String(column));
                    for (Long t : navigableMap.get(family).get(column).keySet()) {
                        System.out.println("值:" + new String(navigableMap.get(family).get(column).get(t)));
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        String name = "yibao";
        valueFilterFuzzy(name, "f");

    }
}
