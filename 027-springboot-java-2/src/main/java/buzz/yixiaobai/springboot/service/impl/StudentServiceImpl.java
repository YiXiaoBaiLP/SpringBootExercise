package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * Student 服务实现类
 * @author yixiaobai
 * @create 2022/05/04 上午2:23
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public String sayHello(String msg) {
        return "say " + msg;
    }
}
