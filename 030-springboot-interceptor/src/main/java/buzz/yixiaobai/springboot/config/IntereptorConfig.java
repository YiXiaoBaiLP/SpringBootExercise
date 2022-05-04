package buzz.yixiaobai.springboot.config;

import buzz.yixiaobai.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yixiaobai
 * @create 2022/05/04 下午3:31
 */
@Configuration // 定义此类为配置类（相当于之前的xml配置文件）
public class IntereptorConfig implements WebMvcConfigurer {

    // mvc:interceptors
    @Override // InterceptorRegistry ： 拦截器注册类
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加要拦截的路径
        String[] addPathPatterns = {
            // 要拦截user下的所有访问请求，必须用户登录才可访问，
            // 但是这样拦截的路径中有一些是不需要用户登录也可以访问的
            "/user/**"
        };
        // 需要排除的地址
        String[] excludePathPatterns = {
             // 不需要用户登录也可以访问
            "/user/login",
            "/user/out",
            "/user/error"
        };
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
