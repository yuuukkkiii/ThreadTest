package com.example.zh.threadtest.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaih
 * @Date: 2022/4/1
 * @Time: 11:34
 * @Description:
 */
@Slf4j
public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try{
            while (countDown-- > 0) {
                log.info(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (Exception e){
            log.error("sleep函数出现异常",e);
        }
    }
}
