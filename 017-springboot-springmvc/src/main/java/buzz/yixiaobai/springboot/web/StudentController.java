package buzz.yixiaobai.springboot.web;

import buzz.yixiaobai.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author yixiaobai
 * @create 2022/05/03 下午2:41
 */
//@Controller
@RestController // 相当于控制层类上加 @Controller + @ResponseBody
                // 意味着当前控制层类中所有方法返回的都是JSON对象
public class StudentController {

    @RequestMapping("/student")
//    @ResponseBody
    public Object queryStudent(){
        Student student = new Student();
        student.setId(1001);
        student.setName("张三");
        student.setAge(18);
        return student;
    }

    // 该请求方式支持：GET 和 POST请求
    @RequestMapping(value =  "/queryStudentById", method ={RequestMethod.GET, RequestMethod.POST})
    public Object queryStudentById(Integer id){
        Student student = new Student();
        student.setId(id);
        student.setName("李四");
        student.setAge(18);
        return student;
    }

    // 通常在查询中使用
    @GetMapping("/queryStudentById2")
    public Object queryStudentById2(Integer id){
        Student student = new Student();
        student.setId(id);
        student.setName("王五");
        student.setAge(18);
        return student;
    }

    // 通常在新增中使用
    @PostMapping("queryStudentById3")
    public Object queryStudentById3(Integer id){
        Student student = new Student();
        student.setId(id);
        student.setName("老刘");
        student.setAge(18);

        return student;
    }

    // 通常在删除中使用
    @DeleteMapping("/deletes")
    public Object delete(){
        return "Delete successful";
    }

    // 通常在更新中使用
    @PutMapping("/update")
    public Object update(){
        return "Update sucessful";
    }
}
