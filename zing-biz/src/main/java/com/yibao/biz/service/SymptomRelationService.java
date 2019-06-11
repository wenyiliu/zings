package com.yibao.biz.service;

import com.yibao.common.entity.Result;

/**
 * @author liuwenyi
 * @date 2019/5/13 20:35
 */
public interface SymptomRelationService {

    /**
     * 通过症状名称查询相关疾病
     *
     * @param symName
     * @return
     */
    Result getDiseaseBySymName(String symName);

    /**
     * 通过疾病名称查询相关的症状
     * @param name
     * @return
     */
    Result getSymptomByDisName(String name);

    /**
     * 根据症状名称获取疾病以及治疗方式
     * @param name
     * @return
     */
    Result getDiseaseAndCureWayBySymName(String name);

}
