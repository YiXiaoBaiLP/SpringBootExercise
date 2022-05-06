package buzz.yixiaobai.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;


/**
 * @author yixiaobai
 * @create 2022/05/06 上午12:31
 */
@Configuration
public class SystemConfig {

    @Bean
    public FilterRegistrationBean characterEncodingFilterRegistrationBean() {

        // 创建字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        // 强制使用指定字符编码
        characterEncodingFilter.setForceEncoding(true);
        // 设置指定字符编码
        characterEncodingFilter.setEncoding("utf-8");

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置字符编码过滤器
        filterRegistrationBean.setFilter(characterEncodingFilter);
        // 设置字符编码器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
