package buzz.yixiaobai.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        /*
        将 SpringApplication.run(Application.class, args) 方法拆分
            1、先获取 SpringApplication 对象
            2、设置SpringApplication对象的属性 setBannerMode(Banner.Mode.OFF);
            3、启动SpringApplication.run(args); 容器
         */
        // 获取启动入口SpringBoot类
        SpringApplication springApplication = new SpringApplication(Application.class);
        // 设置它的属性
        springApplication.setBannerMode(Banner.Mode.OFF);
        // 调用启动类
        springApplication.run(args);
    }
}
