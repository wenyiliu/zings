package com.yibao.biz.bizenun;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/6/4 16:26
 */
public enum ExcelHeaderEnum {

    /**
     * Excel表头
     */
    SERVINGCANCEL(3, Lists.newArrayList("取消服务时间","患者姓名","患者id","服务名称","该服务关联的照护服务","取消前该任务计划时间","取消备注","操作人")),
    SERVINGFINISH(4,Lists.newArrayList("服务完成时间","患者姓名","患者id","服务名称","url","该服务关联的照护服务","该服务计划完成时间","操作人","是否有下一次服务或任务")),
    DAILYPROGRESSNOTE(5,Lists.newArrayList("病程录完成时间","患者id","患者姓名","服务名称","该服务关联的照护服务","操作人","患者在本次服务中提出的疑问", "本次服务中你发现了哪些认为需要干预的问题，以及你计划如何干预",
            "本次服务中是否遇到了你不知道该如何给建议的问题", "本次服务中你是否发现了自己缺失的知识点以及你需要这个知识点的原因","url")),
    ONLINEPATIENT(6,Lists.newArrayList("患者生成时间","患者id","患者姓名","患者关联的医生","患者出生日期","患者年龄","患者所属用户的id","用户微信名","疾病诊断","备注"))

    ;
    @Getter
    private Integer sqlId;

    @Getter
    private List<String> headerList;


    ExcelHeaderEnum(Integer sqlId,List<String> headerList) {
        this.sqlId=sqlId;
        this.headerList=headerList;
    }

    public static List<String> getHeaderListBySqlId(Integer sqlId){
        for (ExcelHeaderEnum e:ExcelHeaderEnum.values()) {
            if (sqlId.equals(e.getSqlId())){
                return e.getHeaderList();
            }
        }
        return null;
    }
}
