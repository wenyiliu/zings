package com.yibao.biz.service.impl;

import com.yibao.biz.service.DepartmentService;
import com.yibao.dao.entity.node.Department;
import com.yibao.dao.repository.node.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwenyi
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

    @Override
    public Boolean insertDepartment(Department department) {
        String name = department.getName();
        if (StringUtils.isBlank(name)) {
            log.error("名字不存在", department.toString());
            return false;
        }
        List<Department> departmentList = departmentRepository.getDepartmentByName(department.getName());
        if (!departmentList.isEmpty()) {
            log.info("已经存在跳过创建", name);
            return true;
        }
        departmentRepository.save(department);
        return true;
    }
}
