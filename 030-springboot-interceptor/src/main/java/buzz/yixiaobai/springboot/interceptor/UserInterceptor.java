package buzz.yixiaobai.springboot.interceptor;

import buzz.yixiaobai.springboot.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 * @author yixiaobai
 * @create 2022/05/04 下午3:07
 */
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 自定义业务拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器--------------------------------------------------------------");
        // 编写业务拦截的规则
        // 从session中获取用户的信息
        User user = (User) request.getSession().getAttribute("user");

        // 判断用户是否登录
        if(null == user){
            // 未登录
            response.sendRedirect(request.getContextPath() + "/user/error");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
