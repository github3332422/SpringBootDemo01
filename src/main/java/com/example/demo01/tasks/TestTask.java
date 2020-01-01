package com.example.demo01.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: demo01
 * @description: .
 * @author: 张清
 * @create: 2019-12-29 20:04
 **/
@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
	@Scheduled(cron = "3-30 * * * * ? ")
    //
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
