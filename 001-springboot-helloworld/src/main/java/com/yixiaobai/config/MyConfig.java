package com.yixiaobai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yixiaobai.bean.Pet;
import com.yixiaobai.bean.User;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、@Configuration注解中添加了一个默认属性proxyBeanMethods：代理Bean的方法
 * 		Full(proxyBeanMethods = true)
 * 		Lite(proxyBeanMethods = false)
 * 		组件依赖
 * @author yixiaobai
 */
@Configuration(proxyBeanMethods = true) // 这是一个配置类 == 配置文件 beans.xml
public class MyConfig {
	
	@Bean // 给容器中添加组件，已方法名作为组件的ID;返回类型就是组件类型。返回的值，就是组件在容器中的实例
	public User user01() {
		User user = new User("ZhangSan", 18);
		// User组件依赖了Pet组件
		user.setPet(pet01());
		return user;
	}
	
	@Bean
	public Pet tomcatPet() {
		return new Pet("tomcatPet");
	}
	
	@Bean("tomcat")// 默认 的组件名称为方法名称，也可以使用此方法来 自定义名称。
	public Pet pet01() {
		return new Pet("tomcat");
	}

}
