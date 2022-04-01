package com.example.zh.threadtest.service.impl;

import com.example.zh.threadtest.entity.SleepingTask;
import com.example.zh.threadtest.entity.TaskWithResult;
import com.example.zh.threadtest.service.BaseThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: zhaih
 * @Date: 2022/4/1
 * @Time: 10:07
 * @Description:
 */
@Slf4j
@Service
public class BaseThreadServiceImpl implements BaseThreadService {
    /**
     * Callable的基本使用
     */
    @Override
    public void baseTestResult() {
        ExecutorService exec= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =new ArrayList<>();
        for(int i=0;i<10;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs:results){
            try {
                log.info(fs.get());
            }catch (Exception e){
                log.error("出错了：",e);
            }finally {
                exec.shutdown();
            }
        }
    }

    @Override
    public void baseSleepResult() {
        ExecutorService exec =Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
