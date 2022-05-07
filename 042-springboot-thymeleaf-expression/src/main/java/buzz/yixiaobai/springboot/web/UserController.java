package buzz.yixiaobai.springboot.web;

import buzz.yixiaobai.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yixiaobai
 * @create 2022/05/07 上午10:14
 */
@Controller
public class UserController {

    @RequestMapping("/user/detail")
    public ModelAndView userDeatil(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1001);
        user.setAge(18);
        user.setUserName("李四");
        modelAndView.setViewName("userDetail");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
