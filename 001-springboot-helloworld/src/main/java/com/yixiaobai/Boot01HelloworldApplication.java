package com.yixiaobai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.yixiaobai.bean.Pet;
import com.yixiaobai.bean.User;
import com.yixiaobai.config.MyConfig;

/**
 * 主程序类
 * @SpringBootApplication： 这是一个spring boot应用 
 * @author yixiaobai
 */
@SpringBootApplication
public class Boot01HelloworldApplication {

	public static void main(String[] args) {
		// 返回我们的IOC容器
		ConfigurableApplicationContext run = SpringApplication.run(Boot01HelloworldApplication.class, args);
		// 查看容器里面的组件
		String[] beanDefinitionNames = run.getBeanDefinitionNames();
		for(String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
		
		// 从容器中的获取组件
		// 容器中获取的Bean组件默认为单实例的
		Pet pet01 = (Pet) run.getBean("tomcat");
		Pet pet02 = run.getBean("tomcat", Pet.class);
		System.out.println("组件是否为单实例：" + (pet01 == pet02));
		
		// 容器中获取配置类
		MyConfig myConfigBean = run.getBean(MyConfig.class);
		System.out.println(myConfigBean);
		
		// 是否可以调用配置类中的方法
		// @Configuration(proxyBeanMethods = true)代理对象调用方法。Spring Boot总会检查这个组件是否在容器中有。
		// 为了保持组件单实例
		User userBean = myConfigBean.user01();
		User userBean01 = myConfigBean.user01();
		System.out.println("MyConfigBean配置类中的User组件是单例吗：" + (userBean == userBean01));
		
		// 当@Configuration(proxyBeanMethods = true)时userBean对象中的pet对象与MyConfig类中pet01()方法为一个对象
		// 当@Configuration(proxyBeanMethods = false)时userBean对象中的pet对象与MyConfig类中pet01()方法不为一个对象
		Pet pet03 = myConfigBean.pet01();
		Pet userBeanPet = userBean.getPet();
		System.out.println("userBean中的pet对象与Pet方法中的是同一个吗？" + (pet03 == userBeanPet));
		
	}

}
