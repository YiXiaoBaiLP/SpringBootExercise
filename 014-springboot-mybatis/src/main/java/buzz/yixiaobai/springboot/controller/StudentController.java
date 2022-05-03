package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学生控制类
 * @author yixiaobai
 * @create 2022/05/02 下午8:21
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public @ResponseBody Student queryStudentById(Integer id){
        return studentService.queryStudentById(id);
    }

}
