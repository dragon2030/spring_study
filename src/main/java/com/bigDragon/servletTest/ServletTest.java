package com.bigDragon.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet代码结构
 * 说明：在Java中，通常所说的Servlet是指HttpServlet对象，在声明一个对象未Servlet时，需要继承HttpServlet类。
 *      HttpServlet类是Servlet接口的一个实现类，继承该类后，可以重写HttpServlet类中的方法对HTTP请求进行处理。
 *
 * @author bigDragon
 * @create 2020-09-15 19:25
 */
public class ServletTest extends HttpServlet {
    //初始化方法
    public void init() throws ServletException{
    }
    //处理HTTP Get请求
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //处理HTTP Post请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    //处理HTTP Put请求
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //处理HTTP Delete请求
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //销毁方法
    public void destroy(){
        super.destroy();
    }
}
