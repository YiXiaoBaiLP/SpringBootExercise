package buzz.yixiaobai.springboot.configuration.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 * @author yixiaobai
 * @create 2022/05/01 下午3:30
 */
@Controller
public class IndexController {

    @Value("${school.name}")
    private String schoolName;

    @Value("${school.websit}")
    private String websit;

    @RequestMapping("say")
    public @ResponseBody String say(){
        return "Hello, SpringBootConfiguration：\t" +
                "schoolName：" +this.schoolName + "\t" +
                "websit："+ this.websit;
    }
}
