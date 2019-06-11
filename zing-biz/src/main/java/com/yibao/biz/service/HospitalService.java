package com.yibao.biz.service;

import com.yibao.common.entity.Result;

/**
 * @author liuwenyi
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

    /**
     * 根据别名获取名字获取医院信息
     * @param name
     * @return
     */
    Result getHospitalByNameOrAlias(String name);

}
