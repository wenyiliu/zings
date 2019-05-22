package com.yibao.biz.bizenun;

import lombok.Getter;

/**
 * @auther: liuwenyi
 * @date 2019/5/6 10:18
 */
public enum QuestionsEnum {

    /**
     * 问题模板索引
     */

    DISEASE_PREVENT(0.0, "ill 预防", "ill/prevent.txt"),
    DISEASE_CAUSE(1.0, "ill 诱因", "ill/cause.txt"),
    DISEASE_DESC(2.0, "ill 简介", "ill/desc.txt"),
    SYMPTOM_CHECK(3.0, "sym 检查", "sym/check.txt"),
    DISEASE_CUREWAY(4.0, "ill 治疗方式", "ill/cureway.txt"),
    DISEASE_CHECK(6.0, "ill 诊断检查", "ill/check.txt"),
    DISEASE_DRUG(7.0, "ill 常用药品", "ill/drug.txt"),
    DISEASE_SYMPTOM(8.0, "ill 症状", "ill/sym.txt"),
    DISEASE_DISEASE(9.0, "ill 并发症", "ill/dis.txt"),
    DISEASE_DEPARTMENT(10.0, "ill 所属科室", "ill/department.txt"),
    SYMPTOM_DISEASE(11.0, "sym 导致疾病", "sym/dis.txt"),
    SYMPTOM_DRUG(5.0, "sym 用药", "sym/drug.txt"),
    SYMPTOM_CUREWAY(12.0, "sym 用药", "sym/cureway.txt"),
    ;

    @Getter
    private Double index;

    @Getter
    private String question;

    @Getter
    private String filePath;

    QuestionsEnum(Double index, String question, String filePath) {
        this.index = index;
        this.question = question;
        this.filePath = filePath;
    }

    public static String getQuestionPattern(Double index) {
        for (QuestionsEnum question : QuestionsEnum.values()) {
            if (index.equals(question.index)) {
                return question.question;
            }
        }
        return null;
    }

}
