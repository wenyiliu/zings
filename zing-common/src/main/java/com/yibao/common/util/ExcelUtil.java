package com.yibao.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @auther: liuwenyi
 * @date 2019/6/3 17:24
 */
@Slf4j
public class ExcelUtil {

    public static Boolean exportExcel(List<Map<String, String>> dataList,
                                    List<String> headers,String path,String exportExcelName) {
        if (dataList.isEmpty()){
            log.error("生成Excel表格数据不能为空");
            return false;
        }

        // 声明一个工作薄
        XSSFWorkbook  workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(exportExcelName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        sheet.setHorizontallyCenter(true);
        sheet.setFitToPage(false);

        // 设置表格标题栏的样式
        XSSFCellStyle style = genContextStyle(workbook);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.size(); i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            XSSFRichTextString text = new XSSFRichTextString(headers.get(i));
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<Map<String, String>> it = dataList.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            Map<String, String> data = it.next();
            int i = 0;
            for (int j = 0; j < headers.size(); j++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                String value=data.getOrDefault(headers.get(i)," ");
                XSSFRichTextString text = new XSSFRichTextString(value);
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
//        style.setTopBorderColor(new XSSFColor(java.awt.Color.BLACK));//设置文本边框颜色
//        style.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK));
//        style.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));
//        style.setRightBorderColor(new XSSFColor(java.awt.Color.BLACK));

        return style;
    }
}
