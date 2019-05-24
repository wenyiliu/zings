package com.yibao.test;

import com.yibao.dao.mapper.business.HospitalMapper;
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
 * @date 2019/5/24 15:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class HospitalMapperTest {

    @Autowired
    private HospitalMapper mapper;

    @Test
    public void getData(){
        List<Map<String, String>> dataList = mapper.getHospitalDepartment();
        System.out.println(dataList.get(0).toString());
    }
}
