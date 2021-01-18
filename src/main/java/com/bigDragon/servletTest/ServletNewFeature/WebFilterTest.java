package com.bigDragon.servletTest.ServletNewFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * WebFilter注解
 *  WebFilter注释用于声明过滤器，该注解将会在部署时被容器处理，容器根据具体的属性配置将相应的类部署为过滤器。
 *      filterName:指定过滤器的name属性，等价于<filter-name>
 *      value:该属性等价于urlPatterns属性，但两者不应该同时使用
 *      urlPatterns:指定一组过滤器URL匹配模式，等价于<url-pattern>标签
 *      servletNames:指定过滤器将应用于哪些Servlet，是@WebServlet中的name属性的取值，或者是web.xml文件中<servlet-name>的取值
 *      initParams:指定一组过滤器初始化参数，等价于<init-param>标签
 *      description:该过滤器的描述信息，等价于<description>标签
 *      displayName:该过滤器的显示名，通常配合工具使用，等价于<display-name>标签
 *      dispatcherTypes:指定过滤器的转发模式。具体取值包括ASYNC、ERROR、FORWARD、INCLUDE、REQUEST
 *
 * @author bigDragon
 * @create 2020-09-28 20:32
 */
//@WebFilter(filterName = "WebFilterTest",urlPatterns = "/*",initParams = { @WebInitParam(name = "name", value = "xc")})
public class WebFilterTest implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(WebFilterTest.class);
    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化处理
        logger.warn("FilterTest过滤器执行");
        logger.warn("public String getFilterName() 用于获取过滤器的名称:"+filterConfig.getFilterName());
        logger.warn("public String getInitParameter(String name) 获取过滤器的初始化参数值:"+filterConfig.getInitParameter("encoding"));
        logger.warn("public Enumeration getInitParameterNames() 获取过滤器的所有初始化参数");
        Enumeration<String> enumeration= filterConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = filterConfig.getInitParameter(name);
            logger.warn(" param-name:"+name+" param-value:"+value);
        }
    }
    //过滤处理方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.warn("FilterTest过滤器doFilter运行");
        //过滤处理
        chain.doFilter(request,response);
    }
    //销毁方法
    @Override
    public void destroy() {
        //释放资源
        logger.warn("FilterTest过滤器关闭");
    }
}
