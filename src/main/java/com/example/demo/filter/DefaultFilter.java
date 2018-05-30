package com.example.demo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring过滤器使用：
 * 通过注解注册过滤器
 * init方法只在服务启动时执行一次，destroy方法只在服务关闭时执行一次
 * doFilter方法在请求到来时执行
 */
@Component
@WebFilter(filterName = "DefaultFilter", urlPatterns = "/test/*")
public class DefaultFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("过滤器的init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        logger.info("过滤器的doFilter方法");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        //这里可以利用request和response做逻辑处理
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("过滤器的destory方法");
    }
}
