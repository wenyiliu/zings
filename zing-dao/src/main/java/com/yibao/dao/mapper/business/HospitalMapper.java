package com.yibao.dao.mapper.business;

import com.yibao.dao.mapper.base.HospitalBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author liuwenyi
 * @date 2019/5/23
 */
@Repository
public interface HospitalMapper extends HospitalBaseMapper {

    /**
     * 获取医院科室信息
     * @return
     */
    List<Map<String,String>> getHospitalDepartment();
}