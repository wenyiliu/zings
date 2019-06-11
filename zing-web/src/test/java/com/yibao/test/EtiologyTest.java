package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Etiology;
import com.yibao.dao.entity.node.Illness;
import com.yibao.dao.entity.relation.EtiologyRelation;
import com.yibao.dao.repository.node.IllnessRepository;
import com.yibao.dao.repository.relation.EtiologyRelationRepository;
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
 * @date 2019/5/29 14:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class EtiologyTest {

    @Autowired
    private EtiologyRelationRepository etiologyRelationRepository;

    @Autowired
    private IllnessRepository illnessRepository;


    public List<Etiology> getEtiologyList(){
        List<Etiology> etiologyList= Lists.newArrayList();
        File file=new File("D:\\projectdata\\JavaProjectData\\demo\\zing\\data\\basecause.txt");
        BufferedReader reader;
        String line;
        try {
            reader=new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!=null){
                String[] split = line.split("\\|");
                Etiology etiology=new Etiology();
                etiology.setType(split[0]);
                etiology.setName(split[1]);
                etiology.setDesc(split[2]);
                etiologyList.add(etiology);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
         return etiologyList;
    }

    @Test
    public void createRelation(){
        List<EtiologyRelation> etiologyRelationList=Lists.newArrayList();
        Illness illness = illnessRepository.findIllnessByName("心衰");
        getEtiologyList().forEach(etiology -> {
            EtiologyRelation etiologyRelation=new EtiologyRelation();
            etiologyRelation.setStartNode(illness);
            etiologyRelation.setEndNode(etiology);
            etiologyRelationList.add(etiologyRelation);
        });
        System.out.println(etiologyRelationList.size());
        etiologyRelationRepository.saveAll(etiologyRelationList);
    }
}
