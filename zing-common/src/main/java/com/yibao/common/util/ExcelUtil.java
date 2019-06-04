package com.yibao.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @auther: liuwenyi
 * @date 2019/6/3 17:24
 */
@Slf4j
public class ExcelUtil {

    public  static Boolean exportExcel(String sheetName, List<Map<String, Object>> dataList,
                                    String[] headers,String path,String exportExcelName) {
        if (dataList.isEmpty()){
            log.error("生成Excel表格数据不能为空");
            return false;
        }

        // 声明一个工作薄
        XSSFWorkbook  workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        sheet.setHorizontallyCenter(true);
        sheet.setFitToPage(false);

        // 设置表格标题栏的样式
        XSSFCellStyle style = genContextStyle(workbook);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<Map<String, Object>> it = dataList.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            Map<String, Object> data = it.next();
            int i = 0;
            for(String key : data.keySet()){
                XSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                XSSFRichTextString text = new XSSFRichTextString(data.get(key)+"");
                cell.setCellValue(text);
                i++;
            }
        }
        writeExcel(workbook,path,exportExcelName);
        return true;
    }
    private static void writeExcel(XSSFWorkbook workbook,String path,String exportExcelName){
        OutputStream out = null;
        try {
            String tmpPath =path+"/"+exportExcelName+ ".xls";
            out = new FileOutputStream(tmpPath);
            workbook.write(out);
        } catch (IOException e) {
            log.error("生成Excel表格失败，原因是：{}",e.getMessage());
        }finally{
            if(workbook != null){
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Map<String, Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<>();
        // 使用 LinkedHashMap 保证有序，即标题和数据对应上
        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("id", 1);
        map1.put("name", "张三");
        map1.put("age", 23);
        map1.put("sex", "男");

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id", 2);
        map2.put("name", "李四");
        map2.put("age", 20);
        map2.put("sex", "女");

        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("id", 3);
        map3.put("name", "王五");
        map3.put("age", 19);
        map3.put("sex", "男");

        Map<String, Object> map4 = new LinkedHashMap<>();
        map4.put("id", 4);
        map4.put("name", "赵六");
        map4.put("age", 18);
        map4.put("sex", "女");

        Map<String, Object> map5 = new LinkedHashMap<>();
        map5.put("id", 5);
        map5.put("name", "小七");
        map5.put("age", 22);
        map5.put("sex", "男");

        data.add(map1);
//        data.add(map2);
        data.add(map3);
        data.add(map4);
//        data.add(map5);

        return data;
    }


    public static void main(String[] args) {
        List<Map<String, Object>> data = ExcelUtil.getData();
        String sheetName = "学生表";
        String[] headers = {"ID","名称","年龄","性别"};
        String exportExcelName = "student2";
        ExcelUtil.exportExcel(sheetName, data, headers, "./data/excel/",exportExcelName);
    }
    //创建文本样式
    private static XSSFCellStyle genContextStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);//文本水平居中显示
        style.setVerticalAlignment(VerticalAlignment.CENTER);//文本竖直居中显示
        style.setWrapText(true);//文本自动换行

        //生成Excel表单，需要给文本添加边框样式和颜色
        style.setBorderBottom(BorderStyle.THIN);//设置文本边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //set border color
        style.setTopBorderColor(new XSSFColor(java.awt.Color.BLACK));//设置文本边框颜色
        style.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK));
        style.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));
        style.setRightBorderColor(new XSSFColor(java.awt.Color.BLACK));

        return style;
    }
}
