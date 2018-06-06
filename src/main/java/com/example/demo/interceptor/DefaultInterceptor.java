package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器，该拦截器需要被加入到spring boot中才会生效
 * preHandle会在请求进入controller的方法前执行，如果返回true，该次请求继续接下来的处理流程；如果返回false，该次请求结束生命周期
 * postHandle会在请求从ontroller的方法返回后执行
 */
public class DefaultInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("进入拦截器的preHandle方法");
        String uri = request.getRequestURI();
        return true;
//        if (uri.contains("test")) {
//            return true;
//        }
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("进入拦截器的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
