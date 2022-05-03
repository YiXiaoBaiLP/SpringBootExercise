package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.service.StudentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student 控制类
 * @author yixiaobai
 * @create 2022/05/03 下午8:31
 */

@RestController
public class StudentController {

    @Reference(interfaceClass = StudentService.class, version = "1.0.0", check = false)
    private StudentService studentService;

    @RequestMapping("/student/count")
    public Object studnetCount(){
        Integer allStudentCount = studentService.queryAllStudentCount();
        return "学生的总人数为：" + allStudentCount;
  }
}
