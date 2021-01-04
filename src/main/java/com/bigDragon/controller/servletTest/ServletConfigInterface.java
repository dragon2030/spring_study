package com.bigDragon.controller.servletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig
 * ServletConfig接口位于javax.servlet包中，它封装了Servlet的配置信息，在Servlet初始化期间被传递。每一个Servlet都有且只有一个ServletConfig对象。该对象定义了4个方法
 *      public String getInitParameter(String name) 返回String类型名称为name的初始化参数值
 *      public Enumeration getInitParameterNames() 获取所有初始化参数名的枚举集合
 *      public ServletContext getServletContext() 用户获取Servlet上下文对象
 *      public String getServletName() 返回Servlet对象的实例名
 *
 * @author bigDragon
 * @create 2020-09-18 17:30
 */
public class ServletConfigInterface extends HttpServlet {
    //定义ServletConfig对象来接收配置的初始化参数
    private ServletConfig config;

    //初始化方法
    public void init(ServletConfig config) throws ServletException{
        System.out.println(this.getClass()+" init方法执行");
        this.config=config;
    }

    /**
     * 处理HTTP Get请求
     *
     * ServletConfig
     * public String getInitParameter(String name) 返回String类型名称为name的初始化参数值 name:Jack
     * public Enumeration getInitParameterNames() 获取所有初始化参数名的枚举集合 name:password value:123 name:name value:Jack
     * public ServletContext getServletContext() 用户获取Servlet上下文对象
     * public String getServletName()ServletConfigInterface
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        //ServletConfig输出方法
        stringBuffer.append("ServletConfig");
        //返回String类型名称为name的初始化参数值
        String paramVal=this.config.getInitParameter("name");
        stringBuffer.append("\npublic String getInitParameter(String name) 返回String类型名称为name的初始化参数值").append(" name:").append(paramVal);
        Enumeration<String> enumeration= this.config.getInitParameterNames();
        stringBuffer.append("\npublic Enumeration getInitParameterNames() 获取所有初始化参数名的枚举集合");
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = this.config.getInitParameter(name);
            stringBuffer.append(" param-name:").append(name).append(" param-value:").append(value);
        }
        stringBuffer.append("\npublic ServletContext getServletContext() 用户获取Servlet上下文对象 ");
        stringBuffer.append("\npublic String getServletName()").append(this.config.getServletName());
        //getServletContext测试
        stringBuffer.append("\n");
        //res.setContentType("text/html");
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
