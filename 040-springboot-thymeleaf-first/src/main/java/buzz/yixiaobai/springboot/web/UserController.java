package buzz.yixiaobai.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yixiaobai
 * @create 2022/05/07 上午12:30
 */
@Controller
public class UserController {

    @RequestMapping("/message")
    public String message(Model model){
        model.addAttribute("data", "SpringBoot 集成Thymeleaf模版引擎");

        return "message";
    }
}
