package buzz.yixiaobai.springboot.contextpath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个控制器
 * @author yixiaobai
 * @create 2022/05/01 下午1:46
 */
@Controller
public class IndexController {

    @RequestMapping("say")
    @ResponseBody
    public String say(){
        return "Hello, Say!";
    }

    @RequestMapping("/mapValue")
    @ResponseBody
    public Map<String, Object> mapValue(){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("message", "SpringBoot Project");
        return retMap;
    }
}
