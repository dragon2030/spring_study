package com.bigDragon.servletTest;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet接口
 * Servlet的运行需要Servlet容器的支持，Servlet容器通过调用Servlet对象提供了标准的API接口，对请求进行处理。在Servlet开发中，任何一个Servlet对象都要直接或间接地实现javax.servlet.Servlet
 *      接口。
 *      public void init(ServletConfig config) Servlet实例化后，Servlet容器动用该方法完成初始化工作
 *      public void service(ServletRequest request, ServletResponse response) 用于处理客户端的请求
 *      public void destroy() 当Servlet对象从Servlet容器中移除时，容器调用该方法，以便释放资源
 *      public ServletConfig getServletConfig() 用于获取Servlet对象的配置信息，返回ServletConfig对象
 *      public String getServletInfo() 返回有关Servlet的信息，它是纯文本格式的字符串，如作者、版本等
 *
 * @author bigDragon
 * @create 2020-09-18 15:22
 */
public class ServletInterface implements Servlet {

    //Servlet实例化后，Servlet容器动用该方法完成初始化工作
    //容器调用 init() 方法进行初始化（仅在第一次加载 Servlet 时调用一次）。
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(this.getClass()+" init方法执行");
    }

    //用于获取Servlet对象的配置信息，返回ServletConfig对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //用于处理客户端的请求
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //res.setContentType("text/html");
        res.setCharacterEncoding("GBK");
        PrintWriter printWriter = res.getWriter();
        System.out.println(this.getClass()+" service方法执行");
        printWriter.println(this.getClass()+" service方法执行");
        printWriter.close();
    }

    //返回有关Servlet的信息，它是纯文本格式的字符串，如作者、版本等
    @Override
    public String getServletInfo() {
        return null;
    }

    //当Servlet对象从Servlet容器中移除时，容器调用该方法，以便释放资源
    @Override
    public void destroy() {
        System.out.println(this.getClass()+" destroy方法执行");
    }
}
