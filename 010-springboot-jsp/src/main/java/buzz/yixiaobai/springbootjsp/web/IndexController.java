package buzz.yixiaobai.springbootjsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器
 * @author yixiaobai
 * @create 2022/05/01 下午6:44
 */
@Controller
public class IndexController {

    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello,SpringBoot");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("message", "Hello, JSP");
        return "index";
    }
}
