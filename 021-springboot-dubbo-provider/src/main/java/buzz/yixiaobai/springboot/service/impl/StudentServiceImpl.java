package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.service.StudentService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author yixiaobai
 * @create 2022/05/03 下午8:37
 */
@Component
@Service(interfaceClass = StudentService.class, version = "1.0.0", timeout = 15000)
public class StudentServiceImpl implements StudentService {

    @Override
    public Integer queryAllStudentCount() {

        // 调用持久层

        return 1250;
    }
}
