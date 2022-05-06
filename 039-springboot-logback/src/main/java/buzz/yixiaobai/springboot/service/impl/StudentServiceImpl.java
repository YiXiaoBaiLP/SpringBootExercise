package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.mapper.StudentMapper;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生类的具体实现
 * @author yixiaobai
 * @create 2022/05/06 下午8:40
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer queryStudentCount() {

        return studentMapper.selectStudentCount();
    }
}
