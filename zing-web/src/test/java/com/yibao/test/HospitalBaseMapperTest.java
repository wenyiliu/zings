package com.yibao.test;

import com.yibao.dao.entity.HospitalDO;
import com.yibao.dao.mapper.base.HospitalBaseMapper;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther: liuwenyi
 * @date 2019/5/23 15:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class HospitalBaseMapperTest {

    @Autowired
    private HospitalBaseMapper hospitalBaseMapper;

    @Test
    public void selectHospitalById(){
        HospitalDO hospital= hospitalBaseMapper.selectById(11);
        System.out.println(hospital.toString());
    }

}
