package com.bigDragon.controller.servletTest;

import com.bigDragon.controller.servletTest.filterTest.CharactorFilter;
import com.bigDragon.controller.servletTest.filterTest.FileMain;
import com.bigDragon.controller.servletTest.filterTest.FilterDemo;
import com.bigDragon.controller.servletTest.listenerTest.ListenerMain;
import com.bigDragon.controller.servletTest.listenerTest.ListenerTest;
import com.bigDragon.model.User1;

/**
 * Servlet 学习知识整理
 *
 * 概念：Servlet是运行在Web服务器的Java应用程序，它使用Java语言编写，具有Java语言的优点。与Java程序的区别是，Servlet对象主要封装了对HTTP请求的处理，并且它的运行需要Servlet容器的支持，
 *      在Java Web应用方法，Servlet的应用占有十分重要的地位，它在Web请求的处理功能方面也非常强大。
 *
 *  一、Servlet结构体系
 *      Servlet实质上是按照Servlet规范编写的Java类，但它可以处理Web应用中的相关请求。Servlet是一个标准，他由Sun公司定义，其具体细节由Servlet容器进行实现，如Tomcat、JBoss等。
 *      接口类 Servlet:
 *      接口类 ServletConfig
 *      接口类 Serializable：java.io包中序列化接口
 *      抽象类 GenericServlet：(实现了Servlet，ServletConfig，Serializable三个接口)该对象未Servlet接口和ServletConfig接口提供了部分实现，但未对HTTP请求处理进行实现。
 *                  对比实现Servlet接口：在编写一个servlet对象时，必须实现javax.servlet.Servlet接口，创建一个Servlet对象需要实现5个方法，这样的操作非常不方便。javax.servlet.GenericServlet
 *                  简化了此操作。GenericServlet是个抽象类，分别实现了除service()之外的其他方法，继承与GenericServlet只需要实现service()方法
 *            HttpServlet：(继承与GenericServlet)这个对象未HTTP请求进行实现，为HTTP请求中POST、GET等类型提供了具体的操作方法。通常情况下所编写的Servlet对象都继承与HttpServlet。
 *                  对比GenericServlet抽象类：实际开发过程中，大多是应用都使用Servlet处理HTTP请求，并作出相应，javax.servlet.http.HttpServlet类对GenericServlet进行了扩展，为HTTP请求
 *                  提供了灵活的方法。HttpServlet仍是一个抽象类，实现了service()方法，并针对HTTP1.1中定义的7中请求类型提供了相应的方法，其中除了doTrance()与doOptions()方法进行简单实现外，
 *                  HttpServlet类并没有对其他方法实现，需要开发人员在使用过程中根据实际需要进行重写。
 *
 *  二、Servlet容器和Web服务器处理一个请求的过程
 *      1.Web 服务器接收 HTTP 请求。
 *      2.Web 服务器将请求转发到 Servlet 容器。
 *      3.如果对应的 Servlet 不在容器中，那么将被动态检索并加载到容器的地址空间中。
 *      4.容器调用 init() 方法进行初始化（仅在第一次加载 Servlet 时调用一次）。
 *      5.容器调用 Servlet 的 service() 方法来处理 HTTP 请求，即读取请求中的数据并构建响应。Servlet 将暂时
 *          保留在容器的地址空间中，可以继续处理其它 HTTP 请求。
 *      6.Web 服务器将动态生成的结果返回到浏览器/客户端。
 *
 *  三、Web容器处理流程
 *      1.client点击一个URL，其URL指向一个servlet
 *      2.容器识别出这个请求索要的是一个servlet，所以创建两个对象：HttpServletRequest、HttpServletResponse
 *      3.容器根据请求中的URL找到对应的servlet，为这个请求创建或分配一个线程，并把两个对象request和response
 *          传递到servlet线程中
 *      4.容器调用servlet的service（）方法。根据请求的不同类型，service（）方法会调用doGet（）或者doPost（）方法
 *      5.doGet（）方法生成动态页面，然后把这个页面填入到response对象中
 *      6.线程结束，容器把response对象转换成http响应，传回client，并销毁response和request对象
 *
 *  四、SpringMVC处理一个请求的流程
 *  SpringMVC流程
 *      1、  用户发送请求至前端控制器DispatcherServlet。
 *      2、  DispatcherServlet收到请求调用HandlerMapping处理器映射器。
 *      3、  处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
 *      4、  DispatcherServlet调用HandlerAdapter处理器适配器。
 *      5、  HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。
 *      6、  Controller执行完成返回ModelAndView。
 *      7、  HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。
 *      8、  DispatcherServlet将ModelAndView传给ViewReslover视图解析器。
 *      9、  ViewReslover解析后返回具体View。
 *      10、 DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。
 *      11、 DispatcherServlet响应用户。

 *  五、Servlet容器处理多线程的方式
 *      Servlet容器默认是采用单实例多线程的方式处理多个请求的：
 *      1.当web服务器启动的时候（或客户端发送请求到服务器时），Servlet就被加载并实例化(只存在一个Servlet实例)；
 *      2.容器初始化化Servlet主要就是读取配置文件（例如tomcat,可以通过servlet.xml的设置线程池中线程数目，初始化线程池通过web.xml,初始化每个参数值等等。
 *      3.当请求到达时，Servlet容器通过调度线程(Dispatchaer Thread) 调度它管理下线程池中等待执行的线程（Worker Thread）给请求者；
 *      4.线程执行Servlet的service方法；
 *      5.请求结束，放回线程池，等待被调用；
 *      （注意：避免使用实例变量（成员变量），因为如果存在成员变量，可能发生多线程同时访问该资源时，都来操作它，照成数据的不一致，因此产生线程安全问题）
 *
 *  六、辨析
 *      Servlet/Servlet容器/WEB容器:
 *          Servlet是运行在服务器端的Java应用程序，Servlet没有main方法，不能独立运行，因此必须把它部署到Servlet容器中，
 *              由容器来实例化并调用Servlet。当用户对容器发送HTTP请求时，容器将通知相应的Servlet对象进行处理，完成用户
 *              与程序之间的交互。
 *          Tomcat和Jetty就是一个Servlet容器。为了方便使用，它们也具有HTTP服务器的功能，因此Tomcat或者Jetty就是一个
 *              “HTTP服务器 + Servlet容器”，我们也叫它们Web容器。
 *
 *      Servlet/Spring/springMVC
 *          spring在很大程度上简化java开发，spring的核心就是通过依赖注入、面向切面编程aop、和模版技术，解耦业务与系统服务，
 *              消除重复代码。借助aop，可以将遍布应用的关注点（如事物和安全）从它们的应用对象中解耦出来。
 *          springMVC框架是围绕这DispatchServlet而工作的，DispatchServlet是一个Servlet，他可以拦截HTTP发送来的请求。
 *          Spring是IOC和AOP的容器框架，SpringMVC是基于Spring功能之上添加的Web框架，想用SpringMVC必须先依赖Spring。
 *
 * @author bigDragon
 * @create 2020-09-15 20:06
 */
public class Main {
    public static void main(String[] args){
        //Servlet代码结构
        Class servletTestClass=ServletTest.class;
        //JavaBean规范样例
        new User1();
        //Servlet测试样例，Servlet配置
        new ServletDemo();

        //Servlet API编程常用接口和类
        //Servlet接口
        new ServletInterface();
        //ServletConfig接口
        new ServletConfigInterface();
        //ServletContext对象
        new ServletContextTest();
        new ServletContextTest2();
        //HttpServletRequest 接口
        new HttpServletRequestTest();
        //HttpServletResponse接口
        new HttpServletResponseTest();

        //Servlet过滤器
        new FileMain();

        //Servlet监听器
        new ListenerMain();
    }
}
