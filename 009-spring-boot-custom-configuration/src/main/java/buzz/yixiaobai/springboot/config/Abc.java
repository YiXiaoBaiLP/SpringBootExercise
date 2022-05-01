package buzz.yixiaobai.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yixiaobai
 * @create 2022/05/01 下午4:14
 */
@Component
@ConfigurationProperties(prefix = "abc")
public class Abc {

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
