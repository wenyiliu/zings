package com.yibao.biz.service;

import com.yibao.biz.model.result.MailBO;

/**
 * @auther: liuwenyi
 * @date 2019/5/28 15:07
 */
public interface MailService {

    Boolean sendSimpleMail(MailBO mail);


}
