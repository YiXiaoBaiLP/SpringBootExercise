package com.yixiaobai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controllel
//@ResponseBody
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello01() {
		return "Hello, Spring Boot 2!";
	}
}
