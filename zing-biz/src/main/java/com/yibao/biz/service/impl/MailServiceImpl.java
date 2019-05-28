package com.yibao.biz.service.impl;

import com.yibao.biz.model.result.MailBO;
import com.yibao.biz.service.MailService;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @auther: liuwenyi
 * @date 2019/5/28 15:08
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;

    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public Boolean sendSimpleMail(MailBO mail) {
        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(mail.getRecipient());
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());
            javaMailSender.send(message);
            log.info("邮件发送成功");
            return true;
        }catch (Exception e){
            log.error("邮件发送异常，原因是：{}",e.getMessage());
            return false;
        }
    }
}
