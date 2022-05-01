package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.config.Abc;
import buzz.yixiaobai.springboot.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yixiaobai
 * @create 2022/05/01 下午4:12
 */
@Controller
public class IndexController {

    @Autowired
    private School school;

    @Autowired
    private Abc abc;

    @RequestMapping("say")
    public @ResponseBody String say(){
        return school.getName() + "\t" + school.getWebsit() + "\t" + abc.getName() + "\t" + abc.getWebsit();
    }
}
