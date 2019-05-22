package com.yibao.biz.service;


import com.yibao.common.entity.Result;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 10:35
 */
public interface CheckRelationService {

    /**
     * 根据疾病名称获取相关检查
     *
     * @param name
     * @return
     */
    Result getCheckByDisName(String name);

    /**
     * 根据症状名称获取相关疾病和检查
     * @param name
     * @return
     */
    Result getCheckAndDiseaseBySymName(String name);
}
