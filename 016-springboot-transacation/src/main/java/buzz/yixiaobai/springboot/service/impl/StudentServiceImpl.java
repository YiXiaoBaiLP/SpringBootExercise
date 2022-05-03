package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.mapper.StudentMapper;
import buzz.yixiaobai.springboot.model.Student;
import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Student 的实现类
 * @author yixiaobai
 * @create 2022/05/03 下午1:36
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int updateStudent(Student student) {

        int nums = studentMapper.updateByPrimaryKey(student);

        // 这里肯定会报错，查看是否支持事务
//        int match = 10/0;

        return nums;
    }
}
