package buzz.yixiaobai.springboot.web;

import buzz.yixiaobai.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 * @author yixiaobai
 * @create 2022/05/04 下午3:36
 */
@RestController
@RequestMapping("/user") // 给请求路径添加一个前缀 user
public class userController {

    /**
     * 登录请求，将用户信息保存到Session中去
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public Object login(HttpServletRequest request){
        User user = new User();
        user.setId(1001);
        user.setName("王五");
        request.getSession().setAttribute("user", user);
        return "Login Success";
    }

    @RequestMapping("/center")
    public Object center(){
        return "See Center Message";
    }

    /**
     * 改请求不登录也可以看
     * @return
     */
    @RequestMapping("/out")
    public Object out(){
        return "Out see anytime";
    }

    /**
     * 如果用户未登录访问了需要登录才可以访问的请求，之后会调转至该请求路径
     * @return
     */
    @RequestMapping("/error")
    public Object error(){
        return "error";
    }
}
