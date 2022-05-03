package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.mapper.StudentMapper;
import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Student 的实现类
 * @author yixiaobai
 * @create 2022/05/03 上午10:58
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
