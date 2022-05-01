package buzz.yixiaobai.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yixiaobai
 * @create 2022/05/01 下午4:10
 */
@Component // 将此类交给Spring容器管理
@ConfigurationProperties(prefix = "school")
public class School {

    private String name;
    private String websit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsit() {
        return websit;
    }

    public void setWebsit(String websit) {
        this.websit = websit;
    }
}
