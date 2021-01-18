package com.bigDragon.servletTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author bigDragon
 * @create 2020-09-19 15:25
 */
public class ServletContextTest2 extends HttpServlet {
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
        String data = this.getClass()+"";
        servletContext.setAttribute("data",data);
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
