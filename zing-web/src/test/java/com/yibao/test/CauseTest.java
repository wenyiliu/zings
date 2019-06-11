package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Cause;
import com.yibao.dao.entity.node.Illness;
import com.yibao.dao.entity.relation.CauseRelation;
import com.yibao.dao.repository.node.CauseRepository;
import com.yibao.dao.repository.node.IllnessRepository;
import com.yibao.dao.repository.relation.CauseRelationRepository;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/29 14:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class CauseTest {

    @Autowired
    private CauseRepository causeRepository;

    @Autowired
    private CauseRelationRepository causeRelationRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    public List<Cause> getCauseList() {
        List<Cause> causeList = Lists.newArrayList();
        File file = new File("D:\\projectdata\\JavaProjectData\\demo\\zing\\data\\cause.txt");
        BufferedReader reader;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                Cause cause = new Cause();
                cause.setName(split[0]);
                cause.setDesc(split[1]);
                causeList.add(cause);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (causeList.isEmpty()){
            return null;
        }
        return causeList;
    }

    @Test
    public void createRelation() {
        Illness illness = illnessRepository.findIllnessByName("心衰");
        List<CauseRelation> causeRelationList=Lists.newArrayList();
        getCauseList().forEach(cause -> {
            CauseRelation causeRelation=new CauseRelation();
            causeRelation.setStartNode(illness);
            causeRelation.setEndNode(cause);
            causeRelationList.add(causeRelation);
        });
       causeRelationRepository.saveAll(causeRelationList);
    }
}
