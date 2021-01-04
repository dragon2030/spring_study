package com.bigDragon.controller.servletTest.filterTest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Servlet过滤器过滤中文乱码
 * @author bigDragon
 * @create 2020-09-22 19:38
 */
public class CharactorFilter implements Filter {
    String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        System.out.println("CharactorFilter过滤器执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(encoding != null){
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset="+encoding);
            System.out.println("CharactorFilter设置请求编码方式为"+encoding);
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        encoding = null;
        System.out.println("CharactorFilter过滤器关闭");
    }
}
