package buzz.yixiaobai.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制类
 * @author yixiaobai
 * @create 2022/05/05 下午11:31
 */
@RestController
public class UserController {

    // 可以进入过滤器
    @RequestMapping("/user/detail")
    public String userDetail(){
        return "/user/detail";
    }
    // 可以进入过滤器
    @RequestMapping("/user")
    public String user(){
        return "/user";
    }
    // 也是可以进入过滤器的
    @RequestMapping("/user/select/detail")
    public String userSelectDetail(){
        return "/user/select/detail";
    }
    // 无法进入过滤器
    @RequestMapping("/center")
    public String center(){
        return "/center";
    }
}
