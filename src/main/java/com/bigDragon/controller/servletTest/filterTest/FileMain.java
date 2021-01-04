package com.bigDragon.controller.servletTest.filterTest;

/**
 * Servlet过滤器
 *
 * 什么是过滤器
 * Servlet过滤器与Servlet十分相似，但它具有拦截客户端请求的功能，Servlet过滤器可以改变请求中的内容来满足实际开发中的需要。对于程序开发人员而言，过滤器实质上就是在Web应用服务器上的一个Web
 * 应用组件，用于拦截客户端与目标资源的请求，并对这些请求进行一定过滤处理再发生给目标资源。
 * 在Web服务器中部署了过滤器以后，不仅客户端发送的请求回经过过滤器的处理，而且请求在发送到目标资源处理以后，请求的回应信息也同样要经过过滤器。
 * 如果一共Web应用中使用一个过滤器不能解决实际中的业务需要，那么可以部署多个过滤器对多个过滤器对业务请求进行多次处理，这样做就组成一个购率取链。Web服务器在处理过滤链时，将按过滤器的先后顺序
 * 对请求进行处理
 *
 * 过滤器核心对象
 * 过滤器对象放置在javax.servlet包中，其名称为Filter，它是一个接口。除这个接口外，与过滤器相关的对象还有FileConfig对象与FilterChain对象，这两个对象也同样是接口对象，位于
 * javax.servlet包中，分别为过滤器的配置对象与过滤器的传递工具。
 *
 * File接口的方法声明及说明
 * 每个过滤器对象都要直接或间接地实现Filter接口，在Filter接口中定义了3个方法，分别为init()方法、doFilter()方法和destroy()方法。
 *      public void init(FilterConfig filterConfig) throws ServletException 过滤器初始化方法，该方法在过滤器初始化时调用
 *      public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException 对请求进行过滤处理
 *      public void destroy() 销毁方法，以便释放资源
 *
 * FilterConfig接口的方法声明及说明
 * FilterConfig接口由Servlet容器进行实现，主要用于获取过滤器中配置信息。
 *      public String getFilterName() 用于获取过滤器的名称
 *      public ServletContext getServletContext() 获取Servlet上下文
 *      public String getInitParameter(String name) 获取过滤器的初始化参数值
 *      public Enumeration getInitParameterNames() 获取过滤器的所有初始化参数
 *
 * FilterChain接口的方法及说明
 * FilterChain接口由Servlet容器进行实现，在这个接口中只有一个方法
 *      public void doFilter(ServletRequest request,ServletResponse response) throws IOException,ServletException 该方法用于将过滤后的请求传递给下一个过滤器，如果此过滤器已经是
 *      过滤链中最后一个过滤器，那么请求将传送给目标资源
 *
 * Servlet过滤器配置
 * 过滤器与Servlet十分相似，在创建之后同意需要对其进行配置，过滤器的配置主要分为两个步骤，分别为声明过滤器对象和创建过滤器映射。
 * <filter>标签用于声明过滤器对象，在这个标签中必须配置两个子元素，分别为过滤器的名称与过滤器完整类名，其中<filter-name>用于定义过滤器的名称，<filter-class>用于指定过滤器的完整类名。
 * <filter-mapping>标签用于创建过滤器的映射，它主要作用就是指定Web应用中哪些URL应用哪一个过滤器进行处理。在<filter-mapping>标签中需要指定过滤器的名称与过滤器的URL映射，其中<filter-name>
 *      用于定义过滤器的名称，<url-pattern>用于指定过滤器应用的URL。
 * @author bigDragon
 * @create 2020-09-28 15:35
 */
public class FileMain {
    public static void main(String[] args){
        //Servlet过滤器样例
        new FilterDemo();
        //Servlet过滤器过滤中文乱码
        new CharactorFilter();
    }
}
