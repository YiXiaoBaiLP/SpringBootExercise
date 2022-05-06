package buzz.yixiaobai.sprinboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的Controller
 * @author yixiaobai
 * @create 2022/05/06 上午11:54
 */
@Controller
public class UserController {

    @RequestMapping("/user/detail")
    public @ResponseBody Object userDetail(){
        Map<String, String> userMap = new HashMap<>();
        userMap.put("id", "1");
        userMap.put("name", "李四");

        return userMap;
    }

    @RequestMapping("/user/page/detail")
    public String userPageDetail(Model model){
        model.addAttribute("id", "1001");
        model.addAttribute("name", "WangWu");
        return "userDetail";
    }
}
