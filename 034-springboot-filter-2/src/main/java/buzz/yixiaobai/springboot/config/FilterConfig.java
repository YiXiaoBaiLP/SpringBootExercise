package buzz.yixiaobai.springboot.config;

import buzz.yixiaobai.springboot.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yixiaobai
 * @create 2022/05/05 下午11:28
 */
@Configuration // 定义此类为配置类
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        // 将自己的过滤器传入进去
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());

        // 添加过滤路径
        filterRegistrationBean.addUrlPatterns("/user/*");

        return filterRegistrationBean;
    }
}
