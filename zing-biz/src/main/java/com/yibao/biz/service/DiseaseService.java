package com.yibao.biz.service;

import com.yibao.biz.model.result.DiseaseBO;
import com.yibao.common.entity.Result;
import com.yibao.dao.entity.Disease;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/4/30 18:05
 */
public interface DiseaseService {

    /**
     * 获取疾病诱因
     *
     * @param name
     * @return
     */
    Result getDisCauseName(String name);
    /**
     * 获取疾病防御措施
     *
     * @param name
     * @return
     */
    Result getDisPreventByName(String name);

    /**
     * 获取疾病治疗方式
     *
     * @param name
     * @return
     */
    Result getDisCureWayByName(String name);
    /**
     * 获取疾病描述
     *
     * @param name
     * @return
     */
    Result getDisDescByName(String name);

    /**
     * 根据疾病名称获取疾病
     *
     * @param name
     * @return
     */
    List<Disease> getDiseaseByName(String name);

    DiseaseBO setDiseaseBO(Disease disease);

    /**
     * 并发症
     *
     * @param name
     * @return
     */
    Result getSyndromeByDiseaseName(String name);

    /**
     * 获取疾病所属科室
     *
     * @param name
     * @return
     */
    Result getDepartmentByDisName(String name);

}
