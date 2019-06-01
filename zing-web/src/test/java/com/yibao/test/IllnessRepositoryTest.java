package com.yibao.test;

import com.yibao.dao.entity.node.Illness;
import com.yibao.dao.repository.node.IllnessRepository;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther: liuwenyi
 * @date 2019/5/29 11:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class IllnessRepositoryTest {

    @Autowired
    private IllnessRepository illnessRepository;

    @Test
    public void getIllness(){
        Illness illness = illnessRepository.findIllnessByName("心力衰竭");
        System.out.println(illness.toString());
    }
}
