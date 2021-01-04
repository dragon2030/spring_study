package com.bigDragon.controller.servletTest.ServletNewFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WebInitParam注解
 * 该注释等价于web.xml文件中<servlet>和<filter>的<init-param>子标签，该注释通常不单独使用，而是配合@WebServlet或者@WebServlet使用。它的作用是为了Servlet或者过滤器指定初始化参数。
 *      name:指定参数的名字，等价于<param-name>
 *      value:指定参数的值，等价于<param-value>
 *      description:关于参数的描述，等价于<description>
 * @author bigDragon
 * @create 2020-09-29 9:13
 */
@WebServlet(name = "webInitParamTest",urlPatterns = "/WebInitParamTest",initParams = { @WebInitParam(name = "name", value = "xc")})
public class WebInitParamTest extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(WebInitParamTest.class);
    //初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException{
        String name = config.getInitParameter("name");
        logger.warn("WebInitParamTest类init请求执行name:"+name);
    }
    //销毁方法
    @Override
    public void destroy(){
        logger.warn("WebInitParamTest类destroy");
        super.destroy();
    }
    //处理HTTP Get请求
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.warn("WebInitParamTest类doGet请求执行");
    }
    //处理HTTP Post请求
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
