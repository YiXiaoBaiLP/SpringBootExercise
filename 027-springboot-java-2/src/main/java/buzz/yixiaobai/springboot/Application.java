package buzz.yixiaobai.springboot;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        // SpringBoot启动程序， 会初始话Spring容器
        SpringApplication.run(Application.class, args);
    }

    /**
     * 重写 CommandLineRunner 类中的方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // 调用业务方法
        String sayHello = studentService.sayHello("World！");
        System.out.println(sayHello);
    }
}
