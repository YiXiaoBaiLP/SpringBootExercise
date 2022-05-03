package buzz.yixiaobai.springboot.controller;

import buzz.yixiaobai.springboot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 学生控制类
 * @author yixiaobai
 * @create 2022/05/03 下午3:45
 */
@RestController
public class StudentController {

    /**
     * 默认的请求风格
     * @param id
     * @param age
     * @return
     */
    @RequestMapping("/student")
    public Object student(Integer id, Integer age){
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        return student;
    }

    /**
     * RESTful 请求风格
     * @param id
     * @param age
     * @return
     */
//    @RequestMapping("/student/detail/{id}/{age}")
    @GetMapping("/student/detail/{id}/{age}")
    public Object studentRESTful(@PathVariable("id") Integer id, // 使用 @PathVariable 注解获取请求参数上的变量
                                 @PathVariable("age") Integer age){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("age", age);

        return retMap;
    }

    /**
     * RESTful 请求风格2
     * @param id
     * @param status
     * @return
     */
//    @RequestMapping("/student/detail/{id}/{status}")
    @DeleteMapping("/student/detail/{id}/{status}")
    public Object studentRESTful2(@PathVariable("id") Integer id,
                                  @PathVariable("status") Integer status){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("status", status);

        return retMap;
    }

    // 以上代码 studentRESTful1 与 studentRESTful2 会出现请求路径冲突的问题
    // 通常在 RESTful 风格中方法的请求方式会按照增删改查的方式来区分
    // RESTful 请求风格要求路径中使用的单词都是名词，最好不要出现动词


    @PostMapping("/student/{id}/detail/{city}")
    public Object studentRESTful3(@PathVariable Integer id,
                                  @PathVariable String city){
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("id", id);
        retMap.put("city", city);
        return retMap;
    }

    @PutMapping("/student/{id}/detail/{city}")
    public Object studentRETful4(@PathVariable Integer id,
                                 @PathVariable String city){
        return "Update successful!!!";

    }
}
