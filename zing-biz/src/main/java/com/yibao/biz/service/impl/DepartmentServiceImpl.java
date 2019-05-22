package com.yibao.biz.service.impl;

import com.yibao.biz.service.DepartmentService;
import com.yibao.dao.eneity.node.Department;
import com.yibao.dao.repository.node.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 18:15
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public int batchInsert(List<Department> departmentList) {
        List departments = (List) departmentRepository.saveAll(departmentList);
        return departments.size();
    }
}
