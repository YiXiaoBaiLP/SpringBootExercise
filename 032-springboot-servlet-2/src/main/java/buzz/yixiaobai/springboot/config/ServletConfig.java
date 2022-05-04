package buzz.yixiaobai.springboot.config;

import buzz.yixiaobai.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Servlet的配置类
 * @author yixiaobai
 * @create 2022/05/04 下午4:36
 */
@Configuration // 此注解将此类定义为一个配置类（相当于一个xml配置文件）
public class ServletConfig {

    /*
    @Bean：是一个方法级别上的注解，主要用在配置类里
    相当于一个
    <beans>
        <bean id="" class="" />
    </beans>
     */
    @Bean
    public ServletRegistrationBean myServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        return servletRegistrationBean;
    }
}
