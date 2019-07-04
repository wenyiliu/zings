package com.yibao.common.util.hbase;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuwenyi
 * @date 2019/07/02
 */
@Slf4j
public class HBaseCreateUtils {

//    private static Admin admin;
//
//    static {
//        try {
//            admin = HBaseConnection.connection.getAdmin();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 创建表
//     *
//     * @param tableName        表名
//     * @param columnFamilyList 列族，可以添加多个列族
//     * @return Boolean
//     */
//    public static Boolean createTable(String tableName, List<String> columnFamilyList) {
//        TableName name = TableName.valueOf(tableName);
//        try {
//            if (admin.tableExists(name)) {
//                log.info("{}已经存在", tableName);
//                return true;
//            }
//            HTableDescriptor descriptor = new HTableDescriptor(name);
//            if (columnFamilyList.isEmpty()) {
//                log.error("{}的列族不能为空", tableName);
//                return false;
//            }
//            columnFamilyList.forEach(columnFamily -> {
//                descriptor.addFamily(new HColumnDescriptor(columnFamily));
//            });
//            admin.createTable(descriptor);
//            return true;
//        } catch (IOException e) {
//            log.error("创建{}失败，原因：{}", tableName, e);
//            e.printStackTrace();
//            return false;
//        }
//    }

}
