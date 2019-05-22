package com.yibao.biz.service;

import com.yibao.common.entity.Result;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 19:49
 */
public interface HospitalService {

    /**
     * 批量插入
     *
     * @return
     * @throws Exception
     */
    int batchInsert();

    Result getHospitalByNameOrAlias(String name);
}
