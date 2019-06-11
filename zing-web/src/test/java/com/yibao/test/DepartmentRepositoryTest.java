package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Department;
import com.yibao.dao.repository.node.DepartmentRepository;
import com.yibao.web.ZingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/23 14:44
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void add(){
        String name="精神病科室";
        List<Department> departmentList = departmentRepository.getDepartmentByName(name);
        if (!departmentList.isEmpty()){
            log.info("{}已经存在，跳过创建",name);
            return;
        }
        Department department=new Department();
        department.setName(name);
        departmentRepository.save(department);
    }

    @Test
    public void getDep(){
        List<Department> departmentList = departmentRepository.getDepartmentByName("消化内科");
        departmentList.forEach(department -> System.out.println(department.getName()));
    }

    @Test
    public void addAll(){
        //todo
        List<Department> departmentList= Lists.newArrayList();
        departmentRepository.saveAll(departmentList);
    }
}
