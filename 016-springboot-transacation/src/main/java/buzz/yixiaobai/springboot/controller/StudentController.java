package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Student 控制类
 * @author yixiaobai
 * @create 2022/05/03 下午1:39
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/update/student")
    public @ResponseBody int updateStudent(int id, String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return studentService.updateStudent(student);
    }
}
