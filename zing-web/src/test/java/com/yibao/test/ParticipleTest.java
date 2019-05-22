package com.yibao.test;

import com.yibao.biz.model.Answer;
import com.yibao.biz.process.Participle;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther: liuwenyi
 * @date 2019/5/21 19:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class ParticipleTest {

    @Test
    public void test(){
        Answer answer = Participle.analyQuery("鼾症做什么检查");
        System.out.println(answer);
    }
}
