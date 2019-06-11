package com.yibao.test;

import com.yibao.biz.service.DiseaseService;
import com.yibao.dao.entity.Disease;
import com.yibao.dao.repository.node.DiseaseRepository;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/21 16:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class DiseaseTest {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private DiseaseService diseaseService;

    @Test
    public void getDiseaseByName() {
        List<Disease> list = diseaseService.getDiseaseByName("鼾症");
        list.forEach(System.out::println);
//        List<String> list = diseaseRepository.getCauseDiseaseName("鼾症");
//        list.forEach(System.out::println);
    }
}
