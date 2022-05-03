package buzz.yixiaobai.springboot.server;

import buzz.yixiaobai.springboot.model.Student;

/**
 * @author yixiaobai
 * @create 2022/05/02 下午4:01
 */
public interface StudentService {

    Student queryStudentById(Integer id);
}
