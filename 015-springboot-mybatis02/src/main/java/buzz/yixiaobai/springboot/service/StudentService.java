package buzz.yixiaobai.springboot.service;

import buzz.yixiaobai.springboot.model.Student;

/**
 * Student 服务类
 * @author yixiaobai
 * @create 2022/05/03 上午10:57
 */
public interface StudentService {

    Student queryStudentById(Integer id);
}
