package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Student 服务层
 * @author yixiaobai
 * @create 2022/05/03 上午11:02
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
