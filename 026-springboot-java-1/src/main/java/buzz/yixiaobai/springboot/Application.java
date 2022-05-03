package buzz.yixiaobai.springboot;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*
        SpringBoot 程序启动后，返回值是 ConfigurableApplicationContext，它是一个Spring容器
        它其实相当于原来Spring容器中启动容器ClasspathXmlApplicationContext
         */
        // 获取容器
        ConfigurableApplicationContext springApplication = SpringApplication.run(Application.class, args);
        // 从容器中获取指定bean对象
        StudentService studentService = (StudentService) springApplication.getBean("studentServiceImpl");
        // 调用业务方法
        String sayHello = studentService.sayHello();
        System.out.println(sayHello);
    }

}
