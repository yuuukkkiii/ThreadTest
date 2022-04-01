package com.example.zh.threadtest.controller;

import com.example.zh.threadtest.service.BaseThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaih
 * @Date: 2022/4/1
 * @Time: 9:58
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/thread/test")
public class BaseThreadController {
    @Autowired
    private BaseThreadService threadService;

    @GetMapping("/baseResult")
    public String baseResult(Integer id){
        if(id==0){
            threadService.baseTestResult();
            return "true";
        }
        return "false";
    }
}
