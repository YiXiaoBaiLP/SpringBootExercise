package buzz.yixiaobai.springboot.service;

/**
 * Student 服务类
 * @author yixiaobai
 * @create 2022/05/03 下午7:13
 */
public interface StudentService {

    /**
     * 将值存放入Redis中
     * @param key
     * @param value
     */
    void put(String key, String value);

    /**
     * 从Redis 中获取值
     * @param key
     * @return
     */
    String get(String key);
}
