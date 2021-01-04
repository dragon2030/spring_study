package com.bigDragon.controller.servletTest.ServletNewFeature;

import com.bigDragon.controller.servletTest.listenerTest.HttpSessionActivationListenerTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *  @WebServlet注释实现数据库访问
 *      @WebServlet定义在Servlet的类声明之前，用于定于Servlet组件。使用该注释，就无须在web.xml文件中对Servlet进行配置。
 *      name：指定Servlet的name属性，等价于<servlet-name>。如果没有显式指定，则该Servlet的取值即为类的全限定名。
 *      value：该属性等价于urlPattern属性。两个属性不能同时使用。
 *      urlPatterns:指定一组Servlet的URL匹配模式，等价于<url-pattern>标签
 *      loadOnStartup:指定一组Servlet初始化参数，等价于<init-param>标签
 *      asyncSupported:声明Servlet是否支持异步操作模式，等价于<async-supported>标签
 *      description:该Servlet的描述信息，等价于<description>标签
 *      displayName:该Servlet的显示名，通常配置工具使用，等价于<display-name>标签
 *
 * @author bigDragon
 * @create 2020-09-28 16:05
 */
//@WebServlet(name = "webServletTest",urlPatterns = "/WebServletTest")
public class WebServletTest extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(WebServletTest.class);

    private Connection connection = null;
    //初始化方法
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dragon?useSSL=false",
                    "root","root");
            if (connection!=null){
                logger.warn("数据库连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //处理HTTP Get请求
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String queryStr = request.getQueryString();
            String sql = "update user u set u.age='40' where u.user_id=1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int result=preparedStatement.executeUpdate();
            logger.warn("sql执行结果："+result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //处理HTTP Post请求
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    //销毁方法
    @Override
    public void destroy(){
        try {
            connection.close();
            super.destroy();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
