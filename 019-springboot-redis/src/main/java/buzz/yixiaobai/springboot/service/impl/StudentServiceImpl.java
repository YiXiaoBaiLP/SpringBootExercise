package buzz.yixiaobai.springboot.service.impl;

import buzz.yixiaobai.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yixiaobai
 * @create 2022/05/03 下午7:40
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired // RedisTemplate：由 spring-data-redis 提供支持
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * Redis 中存入数据
     * @param key
     * @param value
     */
    @Override
    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        String value = redisTemplate.opsForValue().get(key).toString();
        return value;
    }

}
