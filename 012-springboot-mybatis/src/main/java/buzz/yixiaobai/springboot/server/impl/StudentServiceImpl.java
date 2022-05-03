package buzz.yixiaobai.springboot.server.impl;

import buzz.yixiaobai.springboot.mapper.StudentMapper;
import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Student 的实现类
 * @author yixiaobai
 * @create 2022/05/02 下午4:02
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
