package com.yibao.biz.bizenun;

import lombok.Getter;

import java.io.File;

/**
 * @author liuwenyi
 * @date 2019/5/6 10:18
 */
public enum QuestionsEnum {

    /**
     * 问题模板索引
     */

    DISEASE_PREVENT(0, "ill 预防", "ill" + File.separator + "prevent.txt"),
    DISEASE_CAUSE(1, "ill 诱因", "ill" + File.separator + "cause.txt"),
    DISEASE_DESC(2, "ill 简介", "ill" + File.separator + "desc.txt"),
    SYMPTOM_CHECK(3, "sym 检查", "sym" + File.separator + "check.txt"),
    DISEASE_CUREWAY(4, "ill 治疗方式", "ill" + File.separator + "cureway.txt"),
    DISEASE_CHECK(6, "ill 诊断检查", "ill" + File.separator + "check.txt"),
    DISEASE_DRUG(7, "ill 常用药品", "ill" + File.separator + "drug.txt"),
    DISEASE_SYMPTOM(8, "ill 症状", "ill" + File.separator + "sym.txt"),
    DISEASE_DISEASE(9, "ill 并发症", "ill" + File.separator + "dis.txt"),
    DISEASE_DEPARTMENT(10, "ill 所属科室", "ill" + File.separator + "department.txt"),
    SYMPTOM_DISEASE(11, "sym 导致疾病", "sym" + File.separator + "dis.txt"),
    SYMPTOM_DRUG(5, "sym 用药", "sym" + File.separator + "drug.txt"),
    SYMPTOM_CUREWAY(12, "sym 治疗", "sym" + File.separator + "cureway.txt"),
    ;

    @Getter
    private Integer index;

    @Getter
    private String question;

    @Getter
    private String filePath;

    QuestionsEnum(Integer index, String question, String filePath) {
        this.index = index;
        this.question = question;
        this.filePath = filePath;
    }
}