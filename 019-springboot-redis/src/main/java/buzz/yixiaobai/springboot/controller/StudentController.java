package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis集成，学生控制类
 * @author yixiaobai
 * @create 2022/05/03 下午6:13
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/put")
    public Object put(String key, String value){
        studentService.put(key, value);
        return "值以成功放入Redis";
    }

    @RequestMapping("/get")
    public Object get(String key){
        return studentService.get(key);
    }
}
