package com.example.zh.threadtest.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: zhaih
 * @Date: 2022/4/1
 * @Time: 14:27
 * @Description:
 */
@Data
@Slf4j
public class SimplePriorities implements Runnable {
    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread()+ ":" +countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i=1;i<10000;i++){
                d+=(Math.PI +Math.E)/ i;
                if(i%1000==0){
                    Thread.yield();
                }
            }
            log.info("运行信息{}",this);
            if(--countDown==0){
                return;
            }
        }
    }
}
