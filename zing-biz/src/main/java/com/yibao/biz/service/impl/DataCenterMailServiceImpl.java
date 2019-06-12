package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yibao.biz.bizenun.ExcelHeaderEnum;
import com.yibao.biz.bizenun.MailToEnum;
import com.yibao.biz.model.result.MailBO;
import com.yibao.biz.service.DataCenterMailService;
import com.yibao.biz.service.MailService;
import com.yibao.common.util.ExcelUtil;
import com.yibao.dao.entity.DataCenterSqlDO;
import com.yibao.dao.mapper.business.DataCenterSqlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenyi
 * @date 2019/6/4 16:17
 */
@Slf4j
@Service
public class DataCenterMailServiceImpl implements DataCenterMailService {

    @Autowired
    private DataCenterSqlMapper sqlMapper;

    @Autowired
    private MailService mailService;

    private static final String PATH = "..\\data\\excel\\";
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static List<String> formattingList = Lists.newArrayList("患者在本次服务中提出的疑问",
            "本次服务中你发现了哪些认为需要干预的问题，以及你计划如何干预",
            "本次服务中是否遇到了你不知道该如何给建议的问题",
            "本次服务中你是否发现了自己缺失的知识点以及你需要这个知识点的原因");
    @Value("${spring.mail.recipient}")
    private static String[] recipient;
    @Override
    public Boolean sendMailToGroupOne() {
        MailBO mail = new MailBO();
        mail.setRecipient(recipient);
        mail.setSubject(LocalDate.now().plusDays(-1) + "线上数据");
        mail.setContent(LocalDate.now().plusDays(-1) + "线上数据均在以下附件中，请注意查收。如有问题，请及时联系我！");
        List<String> filePath = Lists.newArrayList();
        MailToEnum.GROUPONE.getSqlId().forEach(sqlId -> {
            DataCenterSqlDO dataCenterSql = sqlMapper.selectById(sqlId);
            if (dataCenterSql.getIsDeleted().equals(0)) {
                List<String> headerList = ExcelHeaderEnum.getHeaderListBySqlId(dataCenterSql.getId());
                String sqls = replaceSqlField(dataCenterSql.getFunctionSql(), "2019-06-01 00:00:00", "2019-06-04 23:59:59");
                List<Map<String, Object>> dataList = sqlMapper.executeSql(sqls);
                if (dataList.isEmpty()) {
                    log.info("{}数据为空，不用生成Excel文件", dataCenterSql.getFunctionName());
                } else {
                    Boolean b = ExcelUtil.exportExcel(formatting(dataList), headerList, PATH, dataCenterSql.getFunctionName());
                    if (b) {
                        filePath.add(PATH + dataCenterSql.getFunctionName() + ".xls");
                    } else {
                        log.error("{},生成Excel文件失败", dataCenterSql.getFunctionName());
                    }
                }
            }
        });
        mail.setPathList(filePath);
        return mailService.sendExcelMail(mail);
    }

    private static List<Map<String, String>> formatting(List<Map<String, Object>> list) {
        List<Map<String, String>> excelDataList = Lists.newArrayList();
        list.forEach((Map<String, Object> data) -> {
            Map<String, String> excelDataMap = Maps.newHashMap();
            data.forEach((key, value) -> {
                if (key.contains("时间")) {
                    try {
                        Date date = format.parse(String.valueOf(value));
                        String time = format.format(date);
                        excelDataMap.put(key, time);
                    } catch (ParseException e) {
                        log.error("当key={}，value={}是，时间转换失败，原因是：{}", key, value, e.getCause());
                    }
                } else if (key.equals("病程录日常问题")) {
                    String[] questions = value.toString().split("【");
                    for (String question : questions) {
                        String[] qa = question.split("】");
                        if (formattingList.contains(qa[0])) {
                            excelDataMap.put(qa[0], qa[1]);
                        }
                    }
                } else if (key.equals("患者出生日期")) {
                    LocalDate.parse((CharSequence) value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } else {
                    excelDataMap.put(key, String.valueOf(value));
                }
            });
            excelDataList.add(excelDataMap);
        });
        return excelDataList;
    }

    private static String replaceSqlField(String sql, String strDate, String endDate) {
        return sql.replace("#{strDate}", " '" + strDate + "' ")
                .replace("#{endDate}", " '" + endDate + "' ");
    }
}
