package com.bigDragon.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse接口
 *
 * HttpServletResponse接口位于javax.servlet.http包中，它继承了javax.servlet.ServletResponse接口，是一个非常重要的对象。
 *
 * HttpServletResponse接口的常用方法及说明
 * public void addCookie(Cookie cookie):向客户端写入cookie信息
 * public void sendError(int sc):发送一个错误状态码为sc的错误响应到客户端
 * public void sendError(int sc,String msg):发送一个包含错误码及错误信息的响应到客户端，参数sc为错误状态码，参数msg为错误信息
 * public void sendRedirect(String location):使用客户端重定向到新的URL，参数location为新的地址
 *
 * @author bigDragon
 * @create 2020-09-19 17:20
 */
public class HttpServletResponseTest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HttpServletResponse接口的常用方法及说明\n");
        Cookie cookie= new Cookie("A","123");
        //向客户端写入cookie信息
        response.addCookie(cookie);
        //发送一个错误状态码为sc的错误响应到客户端
        //response.sendError(0);
        //发送一个包含错误码及错误信息的响应到客户端，参数sc为错误状态码，参数msg为错误信息
        //response.sendError(0,"ERROR3301");
        //使用客户端重定向到新的URL，参数location为新的地址
        response.sendRedirect("../index.jsp");
    }
    //处理HTTP Post请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
