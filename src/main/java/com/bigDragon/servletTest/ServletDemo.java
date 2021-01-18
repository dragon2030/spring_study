package com.bigDragon.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet样例
 *
 * Servlet配置
 * 要使Servlet对象正常地运行，需要进行适当的配置，以告知Web容器哪一个请求调用 哪一个Servlet对象处理，对Servlet起到一个
 *      注册的作用。Servlet的配置包含在web.xml文件中，主要通过以下两步进行配置。
 *      1.声明Servlet对象
 *      在web.xml文件中，通过<servlet>标签声明一个Servlet对象。在此标签下包含两个主要子元素，分别为<servlet-name>与
 *          <servlet-class>。其中，<servlet-name>元素用于指定Servlet的名称，该名称可以为自定义的名称；<servlet-class>
 *          用于指定Servlet对象的完整位置，包含Servlet对象的包名类名。
 *      2.映射Servlet
 *      在web.xml文件中声明了Servlet对象后，需要映射访问Servlet的URL。该操作使用<servlet-mapping>标签进行配置。
 *          <servlet-mapping>标签包含两个子元素，分别为<servlet-name>与<url-pattern>。其中<servlet-name>元素与<servlet>
 *          标签中的<servlet-name>元素相对应，不可以随意命名。<url-pattern>元素用于映射访问URL。
 *
 * @author bigDragon
 * @create 2020-09-18 11:36
 */
public class ServletDemo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Servlet实例</TITLE></HEAD>");
        out.println("<BODY>");
        out.println(" Servlet实例： ");
        out.println(this.getClass());
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
