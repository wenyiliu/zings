package com.yibao.biz.service.impl;

import com.yibao.biz.service.DataCenterResultService;
import com.yibao.dao.entity.DataCenterResultDO;
import com.yibao.dao.mapper.base.DataCenterResultBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: liuwenyi
 * @date 2019/5/21 14:23
 */
@Slf4j
@Service
public class DataCenterResultServiceImpl implements DataCenterResultService {

    @Autowired
    private DataCenterResultBaseMapper dataCenterResultBaseMapper;


    @Override
    public DataCenterResultDO getDataByID(Integer id) {
        return dataCenterResultBaseMapper.selectById(id);
    }
}
