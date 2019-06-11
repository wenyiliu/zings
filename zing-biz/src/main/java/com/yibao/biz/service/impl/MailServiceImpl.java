package com.yibao.biz.service.impl;

import com.yibao.biz.model.result.MailBO;
import com.yibao.biz.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author liuwenyi
 * @date 2019/5/28 15:08
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public Boolean sendExcelMail(MailBO mail) {
        MimeMessage message=javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(sender);
            helper.setTo(mail.getRecipient());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent());
            if (mail.getPathList().isEmpty()){
                log.error("附件为空，取消发送");
                return false;
            }
            mail.getPathList().forEach(path->{
                FileSystemResource file=new FileSystemResource(new File(path));
                String name=path.substring(path.lastIndexOf(File.separator));
                try {
                    helper.addAttachment(name, file);
                } catch (MessagingException e) {
                    log.error("添加附件:{}失败，原因是：{}",name,e.getCause());
                }
            });
            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error("邮件发送异常，原因是：{}",e.getCause());
            return false;
        }
        return true;
    }
}
