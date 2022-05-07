package buzz.yixiaobai.springboot.web;

import buzz.yixiaobai.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/url")
    public ModelAndView url(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", 1001);
        mv.addObject("username", "王五");
        mv.addObject("age", 18);
        mv.setViewName("url");
        return mv;
    }

    @RequestMapping("/test")
    public @ResponseBody String test(String userName){
        return "请求路径/test，参数是：" + userName;
    }

    @RequestMapping("/test1")
    public @ResponseBody String test(Integer id, String username, Integer age){
        return "请求路径/test1，参数id=" + id +
                ",username" + username +
                ",age" + age;
    }

    /**
     * 使用RESTful格式
     */
    @RequestMapping("/test2/{id}")
    public @ResponseBody String test2(@PathVariable("id") Integer id){
        return "参数路中获取的id为：" + id;
    }

    @RequestMapping("/test3/{id}/{username}")
    public @ResponseBody String test3(@PathVariable("id") Integer id, @PathVariable("username") String username){
        return "ID=" + id + "username=" + username;
    }


    @RequestMapping("/url2")
    public String url2(Model model){
        return "url2";
    }
}
