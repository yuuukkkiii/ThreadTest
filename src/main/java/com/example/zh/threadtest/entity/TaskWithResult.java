package com.example.zh.threadtest.entity;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @Author: zhaih
 * @Date: 2022/4/1
 * @Time: 9:59
 * @Description:
 */
@Data
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id){
        this.id=id;
    }
    @Override
    public String call() throws Exception {
        return "该线程的id为："+id;
    }
}
