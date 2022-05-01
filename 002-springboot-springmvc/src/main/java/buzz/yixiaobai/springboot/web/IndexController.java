package buzz.yixiaobai.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yixiaobai
 * @create 2022/05/01 下午1:34
 */
@Controller // 注册为一个控制器
public class IndexController {

    @RequestMapping("/springboot/say")
    @ResponseBody
    public  String say(){
        return "Hello, SpringBoot!";
    }
}
