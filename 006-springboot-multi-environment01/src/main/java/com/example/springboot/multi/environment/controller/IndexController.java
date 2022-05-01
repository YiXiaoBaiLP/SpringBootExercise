package com.example.springboot.multi.environment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 * @author yixiaobai
 * @create 2022/05/01 下午3:10
 */
@Controller
public class IndexController {

    @RequestMapping("say")
    @ResponseBody
    public String say() {
        return "Hello, SpringBoot!";
    }

}
