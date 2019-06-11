package com.yibao.test;

import com.google.common.collect.Lists;
import com.yibao.dao.entity.node.Genre;
import com.yibao.dao.entity.node.Illness;
import com.yibao.dao.entity.relation.GenreRelation;
import com.yibao.dao.repository.node.GenreRepository;
import com.yibao.dao.repository.node.IllnessRepository;
import com.yibao.dao.repository.relation.GenreRelationRepository;
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
 * @date 2019/5/29 10:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class GenreTest {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    @Autowired
    private GenreRelationRepository genreRelationRepository;

    public List<Genre> getGenreList(){
        File file = new File("D:\\projectdata\\JavaProjectData\\demo\\zing\\data\\genre.txt");
        BufferedReader reader;
        String line;
        List<Genre> genreList = Lists.newArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\\|");
                Genre genre = new Genre();
                if (s[0]!=null||!s[0].equals(" ")){
                    genre.setType(s[0]);
                }
                if (s[1]!=null||!s[1].equals(" ")){
                    genre.setName(s[1]);
                }
                if (s[2]!=null||!s[2].equals(" ")){
                    genre.setCause(s[2]);
                }
                if (s[3]!=null||!s[3].equals(" ")){
                    genre.setCharacteristic(s[3]);
                }
                genreList.add(genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (genreList.isEmpty()){
            return null;
        }
        return genreList;
    }

    @Test
    public void addAll() {
        genreRepository.saveAll(getGenreList());
    }

    @Test
    public void createRelation(){
        List<Genre> genreList = getGenreList();
        List<GenreRelation> genreRelationList=Lists.newArrayList();
        Illness illness = illnessRepository.findIllnessByName("心衰");
        genreList.forEach(genre -> {
            GenreRelation relation=new GenreRelation();
            relation.setStartNode(illness);
            relation.setEndNode(genre);
            genreRelationList.add(relation);
        });
        System.out.println(genreRelationList.size());
        genreRelationRepository.saveAll(genreRelationList);
    }
}
