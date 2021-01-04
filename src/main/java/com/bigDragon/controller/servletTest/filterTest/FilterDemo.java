package com.bigDragon.controller.servletTest.filterTest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet过滤器样例
 *
 * @author bigDragon
 * @create 2020-09-22 11:23
 */
public class FilterDemo implements Filter {
    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化处理
        System.out.println("FilterTest过滤器执行");
        System.out.println("public String getFilterName() 用于获取过滤器的名称:"+filterConfig.getFilterName());
        System.out.println("public String getInitParameter(String name) 获取过滤器的初始化参数值:"+filterConfig.getInitParameter("encoding"));
        System.out.println("public Enumeration getInitParameterNames() 获取过滤器的所有初始化参数");
        Enumeration<String> enumeration= filterConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println(" param-name:"+name+" param-value:"+value);
        }
    }
    //过滤处理方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterTest过滤器doFilter运行");
        //过滤处理
        chain.doFilter(request,response);
    }
    //销毁方法
    @Override
    public void destroy() {
        //释放资源
        System.out.println("FilterTest过滤器关闭");
    }
}
