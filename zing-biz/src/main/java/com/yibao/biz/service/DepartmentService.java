package com.yibao.biz.service;


import com.yibao.dao.entity.node.Department;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/14 18:13
 */
public interface DepartmentService {

    /**
     * 批量插入科室
     *
     * @param departmentList
     * @return
     */
    int batchInsert(List<Department> departmentList);

    /**
     * 插入医院科室
     * @param department
     * @return
     */
    Boolean insertDepartment(Department department);
}
