package com.bigDragon.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletRequest 接口位于javax.servlet.http包中，继承了javax.servlet.ServletRequest接口，Servlet中的重要对象，在开发过程中国较为常用。
 *
 * HttpServletRequest接口常用方法及说明
 * public String getContextPath():返回请求的上下文路径，此路径以“/”开头
 * public Cookie[] getCookies():返回请求中发送的所有cookie对象，返回值为cookie数组
 * public String getMethod():返回请求所使用的HTTP类型，如get、post等
 * public String getQueryString():返回请求中参数的字符串形式，如请求MyServlet?username=mr，则返回username=mr
 * public String getRequestURL():返回主机名到请求参数之间的字符串形式
 * public StringBuffer getRequestURL():返回请求的URL，此URL中不包含请求的参数。注意此方法返回的数据类型为StringBuffer
 * public String getServletPath():返回请求URI中Servlet路径的字符串，不包含请求的参数信息
 * public HttpSession getSession():返回与请求关联的HttpSession对象
 *
 *
 * @author bigDragon
 * @create 2020-09-19 16:35
 */
public class HttpServletRequestTest extends HttpServlet {
    /**
     * 请求：http://localhost:8081/spring_study_war_exploded/servlet/HttpServletRequestTest?name=jack
     * 显示结果：
     * HttpServletRequest接口常用方法及说明
     * public String getContextPath():返回请求的上下文路径，此路径以“/”开头/spring_study_war_exploded
     * public Cookie[] getCookies():返回请求中发送的所有cookie对象，返回值为cookie数组[Ljavax.servlet.http.Cookie;@2a6b1bd6
     * public String getMethod():返回请求所使用的HTTP类型，如get、post等GET
     * public String getQueryString():返回请求中参数的字符串形式，如请求MyServlet?username=mr，则返回username=mr
     * public String getRequestURI():返回主机名到请求参数之间的字符串形式
     * public StringBuffer getRequestURL():返回请求的URL，此URL中不包括请求的参数。注意此方法返回的数据类型为StringBuffer
     * public String getServletPath():返回请求URI中Servlet路径的字符串，不包含请求的参数信息/servlet/HttpServletRequestTest
     * public HttpSession getSession():返回与请求关联的HttpSession对象org.apache.catalina.session.StandardSessionFacade@322c001e
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HttpServletRequest接口常用方法及说明\n");
        stringBuffer.append("public String getContextPath():返回请求的上下文路径，此路径以“/”开头"+request.getContextPath()+"\n");
        stringBuffer.append("public Cookie[] getCookies():返回请求中发送的所有cookie对象，返回值为cookie数组"+request.getCookies()+"\n");
        stringBuffer.append("public String getMethod():返回请求所使用的HTTP类型，如get、post等"+request.getMethod()+"\n");
        stringBuffer.append("public String getQueryString():返回请求中参数的字符串形式，如请求MyServlet?username=mr，则返回username=mr"+request.getQueryString()+"\n");
        stringBuffer.append("public String getRequestURL():返回主机名到请求参数之间的字符串形式"+request.getRequestURL()+"\n");
        stringBuffer.append("public String getServletPath():返回请求URI中Servlet路径的字符串，不包含请求的参数信息"+request.getServletPath()+"\n");
        stringBuffer.append("public HttpSession getSession():返回与请求关联的HttpSession对象"+request.getSession()+"\n");

        PrintWriter printWriter = response.getWriter();
        printWriter.println(stringBuffer.toString());
        printWriter.close();
    }
    //处理HTTP Post请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}