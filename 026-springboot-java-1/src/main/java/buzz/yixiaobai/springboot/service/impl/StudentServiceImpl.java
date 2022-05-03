package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author yixiaobai
 * @create 2022/05/04 上午2:02
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHello() {
        return "Say Hello";
    }
}
