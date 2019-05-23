package com.yibao.biz.service;

import com.yibao.common.entity.Result;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 9:47
 */
public interface DrugRelationService {

    /**
     * 根据症状获取疾病以及相关药品
     *
     * @param name
     * @return
     */
    Result getDiseaseAndDrugBySymName(String name);

    /**
     * 根据症状获取疾病
     *
     * @param name
     * @return
     */
    Result getDrugByDisName(String name);

}
