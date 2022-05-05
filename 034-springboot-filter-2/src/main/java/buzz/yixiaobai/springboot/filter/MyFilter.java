package buzz.yixiaobai.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 * @author yixiaobai
 * @create 2022/05/05 下午11:25
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------------- 我进入过滤器了 ---------------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
