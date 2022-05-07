package buzz.yixiaobai.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 * @author yixiaobai
 * @create 2022/05/07 上午12:59
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("data", "SpringBoot Thymeleaf");

        return "index";
    }
}
