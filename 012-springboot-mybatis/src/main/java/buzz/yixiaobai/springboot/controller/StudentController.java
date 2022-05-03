package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Student 的控制器
 * @author yixiaobai
 * @create 2022/05/02 下午4:06
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public @ResponseBody Object student(Integer id){
        Student student = studentService.queryStudentById(id);
        return student;
    }

}
