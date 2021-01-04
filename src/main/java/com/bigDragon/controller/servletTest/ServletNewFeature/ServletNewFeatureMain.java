package com.bigDragon.controller.servletTest.ServletNewFeature;

import com.bigDragon.controller.servletTest.listenerTest.HttpSessionActivationListenerTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet3.0新特性
 *
 * 新增注释：通过使用注释就无须在web.xml文件中对Servlet或过滤器进行配置。Servlet新增的注释有@WebServlet、@WebFilterTest、@WebListener和@WebInitParam等
 *
 * @author bigDragon
 * @create 2020-09-28 16:05
 */
public class ServletNewFeatureMain {
    public static void main(String[] args){
        //@WebServlet注释实现数据库访问
        new WebServletTest();
        //@WebFilter注解
        new WebFilterTest();
        //@WebListener注解
        new WebListenerTest();
        //@WebInitParam注解
        new WebInitParamTest();
        //Servlet对 文件传世的支持
        new ServletUpload();
        //Servlet异步处理
        new ServletAsynchronousProcessing();
    }
}
