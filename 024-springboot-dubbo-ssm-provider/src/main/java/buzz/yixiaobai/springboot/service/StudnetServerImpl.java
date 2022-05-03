package buzz.yixiaobai.springboot.service;

import buzz.yixiaobai.springboot.mapper.StudentMapper;
import buzz.yixiaobai.springboot.model.Student;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Student 服务的实现类
 * @author yixiaobai
 * @create 2022/05/04 上午12:55
 */
@Component
@Service(interfaceName = "buzz.yixiaobai.springboot.service.StudnetServer", version = "1.0.0", timeout = 15000)
public class StudnetServerImpl implements StudnetServer {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer queryAllStudentCount() {
        // 首先去Redis缓存中查询，如果有：直接使用，如果没有：去数据库中查询并放到Redis缓存中
        // 提升系统性能，用户体验提升
        Integer allStudnetCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        if(null == allStudnetCount){
            // 去数据库中查询
            allStudnetCount = studentMapper.selectAllStudentCount();
            // 将查询的数据放入到Redis缓存中，并设置失效时间30秒
            redisTemplate.opsForValue().set("allStudentCount", allStudnetCount, 30, TimeUnit.SECONDS);
        }
        return allStudnetCount;
    }
}
