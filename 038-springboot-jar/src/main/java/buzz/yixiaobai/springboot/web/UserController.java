package buzz.yixiaobai.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制类
 * @author yixiaobai
 * @create 2022/05/06 下午1:52
 */
@Controller
public class UserController {

    @RequestMapping("/user/json/detail")
    public @ResponseBody Object userJsonDetail(){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", 1001);
        retMap.put("username", "wangwu");

        return retMap;
    }

    @RequestMapping("/user/page/detail")
    public String userPageDetail(Model model){
        model.addAttribute("id", 1002);
        model.addAttribute("username", "赵六");
        return "userDetail";

    }
}
