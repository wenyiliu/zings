package com.yibao.test;

import com.yibao.biz.bizenun.MailToEnum;
import com.yibao.biz.model.result.MailBO;
import com.yibao.biz.service.DataCenterMailService;
import com.yibao.biz.service.MailService;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuwenyi
 * @date 2019/6/4 16:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class DataCenterMailServiceTest {

    @Autowired
    private DataCenterMailService mailService;
    @Autowired
    private MailService mail;

    @Test
    public void createExcel(){
        Boolean b = mailService.sendMailToGroupOne();
        if (b){
            System.out.println("邮件发送成功");
        }
    }

    @Test
    public void test(){
        MailBO mailBO=new MailBO();
        mailBO.setRecipient(MailToEnum.GROUPONE.getTo());
        mailBO.setSubject("test");
        mailBO.setContent("88888888888888888");
        mail.sendExcelMail(mailBO);
    }

}
