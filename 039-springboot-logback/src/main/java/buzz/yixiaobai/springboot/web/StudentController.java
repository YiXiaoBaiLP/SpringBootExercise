package buzz.yixiaobai.springboot.web;

import buzz.yixiaobai.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yixiaobai
 * @create 2022/05/06 下午8:36
 */
@Controller
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/count")
    public @ResponseBody String studentCount() {
        log.trace("trace：查询当前学生总人数");
        log.debug("debug：查询当前学生总人数");
        log.info("info：查询当前学生总人数");
        log.warn("warn：查询当前学生总人数");
        log.error("error：查询当前学生总人数");

        Integer studentCount = studentService.queryStudentCount();
        return "学生的总人数为：" + studentCount ;
    }
}
