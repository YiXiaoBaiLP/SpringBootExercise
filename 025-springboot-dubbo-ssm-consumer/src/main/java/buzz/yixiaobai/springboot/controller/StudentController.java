package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudnetServer;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yixiaobai
 * @create 2022/05/04 上午12:47
 */
@Controller
public class StudentController {

    @Reference(interfaceName = "buzz.yixiaobai.springboot.service.StudnetServer", version = "1.0.0", check = false)
    private StudnetServer studnetServer;

    @RequestMapping("/student/detail/{id}")
    public String studentDetail(Model model,
                                @PathVariable("id") Integer id){
        Student student = studnetServer.queryStudentById(id);
        model.addAttribute("student", student);
        return "studentDetail";
    }

    @GetMapping("/student/all/count")
    public @ResponseBody Object allStudentCount(){
        Integer count = studnetServer.queryAllStudentCount();

        return "学生的总人数为：" + count;
    }
}
