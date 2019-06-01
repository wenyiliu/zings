package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Examine;
import com.yibao.dao.entity.node.Illness;
import com.yibao.dao.entity.relation.ExamineRelation;
import com.yibao.dao.repository.node.ExamineRepository;
import com.yibao.dao.repository.node.IllnessRepository;
import com.yibao.dao.repository.relation.ExamineRelationRepository;
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
 * @auther: liuwenyi
 * @date 2019/5/29 11:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class ExamineTest {

    @Autowired
    private ExamineRelationRepository examineRelationRepository;

    @Autowired
    private ExamineRepository examineRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    public List<Examine> getExamineList(){
        File file = new File("D:\\projectdata\\JavaProjectData\\demo\\zing\\data\\check.txt");
        BufferedReader reader;
        String line;
        List<Examine> examineList = Lists.newArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\\|");
                Examine examine = new Examine();
                if (s[0]!=null||!s[0].equals(" ")){
                  examine.setName(s[0]);
                }
                if (s[1]!=null||!s[1].equals(" ")){
                   examine.setCause(s[1]);
                }
                examineList.add(examine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (examineList.isEmpty()){
            return null;
        }
        return examineList;
    }

    @Test
    public void addAll(){
        List<Examine> examineList = getExamineList();
        examineRepository.saveAll(examineList);
    }

    @Test
    public void createRelation(){
        Illness illness = illnessRepository.findIllnessByName("心衰");
        List<Examine> examineList = getExamineList();
        List<ExamineRelation> examineRelationList=Lists.newArrayList();
        examineList.forEach(examine -> {
            ExamineRelation relation=new ExamineRelation();
            relation.setStartNode(illness);
            relation.setEndNode(examine);
            examineRelationList.add(relation);
        });
        examineRelationRepository.saveAll(examineRelationList);
        System.out.println(examineRelationList.size());
    }
}
