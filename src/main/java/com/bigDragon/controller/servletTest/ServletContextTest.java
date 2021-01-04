package com.bigDragon.controller.servletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext对象
 *      Web容器在启动时，会为每个Web应用程序创建一个对应的ServletContext对象，它代表当前web应用。ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，可以通过
 *      ServletConfig.getServletContext方法获得ServletContext对象。由于一个web应用中所有Servlet共享一个ServletContext对象，因此servlet对象之间可以通过ServletContext对象来实现通讯。
 *      ServletContext对象通常也被称之为context域对象。
 *
 * ServletContext对象使用
 * 1.多个Servlet通过ServletContext对象实现数据共享:通过servletContext.setAttribute()和servletContext.getAttribute()
 * 2.获取WEB应用的初始化参数:在web.xml文件中使用<context-param>标签配置WEB应用的初始化参数,servletContext.getInitParameter()读取
 * 3.用servletContext实现请求转发
 * 4.利用ServletContext对象读取资源文件
 *
 * 详见：https://blog.csdn.net/durenniu/article/details/81066817
 *
 * @author bigDragon
 * @create 2020-09-19 15:25
 */
public class ServletContextTest extends HttpServlet {
    //定义ServletConfig对象来接收配置的初始化参数
    private ServletConfig config;

    //初始化方法
    public void init(ServletConfig config) throws ServletException{
        System.out.println(this.getClass()+" init方法执行");
        this.config=config;
    }
    //处理HTTP Get请求
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        ServletContext servletContext = this.config.getServletContext();
        //取出ServletContextTest2中存入的数据
        String str = (String)servletContext.getAttribute("data");
        stringBuffer.append("多个Servlet通过ServletContext对象实现数据共享 servletContext.getAttribute: "+str);
        String urlStr = servletContext.getInitParameter("url");
        stringBuffer.append("\n获取WEB应用的初始化参数 servletContext.getInitParameter: "+urlStr);
        response.setCharacterEncoding("GBK");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(stringBuffer.toString());
        printWriter.close();
    }
    //处理HTTP Post请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
