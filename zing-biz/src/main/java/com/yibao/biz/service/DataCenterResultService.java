package com.yibao.biz.service;


import com.yibao.dao.entity.DataCenterResultDO;

/**
 * @author liuwenyi
 * @date 2019/5/21 14:21
 */
public interface DataCenterResultService {

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    DataCenterResultDO getDataByID(Integer id);

}
