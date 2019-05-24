package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Department;
import com.yibao.dao.entity.node.Hospital;
import com.yibao.dao.entity.relation.HospitalDepartmentRelation;
import com.yibao.dao.mapper.business.HospitalMapper;
import com.yibao.dao.repository.node.DepartmentRepository;
import com.yibao.dao.repository.node.HospitalRepository;
import com.yibao.dao.repository.relation.HospitalDepartmentRelationRepository;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @auther: liuwenyi
 * @date 2019/5/24 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class HospitalDepartmentRelationRepositoryTest {

    @Autowired
    private HospitalDepartmentRelationRepository relation;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private HospitalMapper mapper;

    @Test
    public void save() {
        List<HospitalDepartmentRelation> relationList= Lists.newArrayList();
        List<Map<String, String>> hospitalDepartment = mapper.getHospitalDepartment();
        hospitalDepartment.forEach(hd->{
            String hName= hd.get("name");
            String dName =hd.get("dname");
            List<Hospital> hospitalList = hospitalRepository.getDistinctByNameOrAlias(hName);
            List<Department> departmentList = departmentRepository.getDepartmentByName(dName);
            hospitalList.forEach(hospital -> departmentList.forEach(department -> {
                HospitalDepartmentRelation relation=new HospitalDepartmentRelation(hospital,department);
                relationList.add(relation);
            }));
        });
        relation.saveAll(relationList);
    }

}
