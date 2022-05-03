package buzz.yixiaobai.springboot.service;

import buzz.yixiaobai.springboot.model.Student;

/**
 * @author yixiaobai
 * @create 2022/05/02 下午8:20
 */
public interface StudentService {

    Student queryStudentById(Integer id);
}
