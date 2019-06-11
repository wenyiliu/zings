package com.yibao.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author liuwenyi
 * @date 2019/6/10 12:59
 */
@Component
public class Scheduler {

    @Scheduled(cron = "0 0 14 ? * *")
    public void testTask(){
        System.out.println(LocalDateTime.now()+"测试定时任务");
    }
}
