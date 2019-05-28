package com.yibao.test;

import com.yibao.biz.model.result.MailBO;
import com.yibao.biz.service.MailService;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther: liuwenyi
 * @date 2019/5/28 15:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class MailTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMail(){
        MailBO mailBean = new MailBO();
        String[] recipient={"xiaoyu.lxy@120yibao.com","zhaoshuan.lzs@120yibao.com"};
        mailBean.setRecipient(recipient);
        mailBean.setSubject("数据中心");
        mailBean.setContent("测试SpringBootMail");
        mailService.sendSimpleMail(mailBean);
    }
}
