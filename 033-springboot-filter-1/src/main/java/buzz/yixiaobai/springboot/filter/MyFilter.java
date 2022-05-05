package buzz.yixiaobai.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 * @author yixiaobai
 * @create 2022/05/05 下午11:12
 */
@WebFilter(urlPatterns = "/myfilter")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-------------------------------- 已进入过滤器 ------------------------------------");

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
