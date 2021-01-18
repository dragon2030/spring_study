package com.bigDragon.servletTest.listenerTest;

/**
 * Servlet 监听器
 *
 * 参考博客：https://blog.csdn.net/hbtj_1216/article/details/83015670
 *
 * Servlet监听器概念：
 *      Servlet监听器的作用是监听Web容器的有效期事件，因此它是由容器管理的。利用Listener接口监听在容器中的某个执行程序，并且根据其应用程序的需求做出适应的响应。
 *      Listener是观察者模式的实现，在Servlet中主要用于对context、request、session对象生命周期进行监控。在Servlet2.5规范中定义了8种Listener。
 *
 * 监听器原理 ：
 * 1、存在事件源
 * 2、提供监听器
 * 3、为事件源注册监听器
 * 4、操作事件源，产生事件对象，将事件对象传递给监听器，并且执行监听器相应监听方法
 *
 * Servlet三大作用域(作用域范围ServletContext > Session > Request)
 *      ServletContext （上下文对象）
 *          生命周期:
 *              创建：服务器启动时，为每个web项目创建一个上下文对象。
 *              销毁：服务器关闭时，或者项目移除时。
 *          作用范围：
 *              项目内共享，当前项目下所有程序都可以共享。
 *      Request （请求对象）
 *          生命周期：
 *              创建：请求开始的时候创建，每个请求都会对应自己的request对象。
 *              销毁：请求结束，响应开始的时候
 *          作用范围：
 *              在一次请求中共享，只在当前请求中有效。
 *      Session（会话对象）
 *      生命周期：
 *          创建：在第一次调用request.getSession()方法时，web容器会检查是否已经有对应的session对象存在，如果没有就创建一个session对象。
 *          销毁：当一段时间内session没有被使用（默认30分钟），被销毁；
 *                服务器非正常关闭（强行关闭）时销毁；
 *                调用session.invalidate()手动销毁
 *          作用范围：
 *              在一次会话中（多次请求）共享数据。
 *
 * Servlet中8个Listener接口和6个Event类
 * Servlet上下文监听：Servlet上下文监听可以监听ServletContext对象的创建、删除预计属性添加、删除和修改操作，该监听需要用到两个接口：
 *      ServletContextListener接口：该接口存放在javax.servlet包内，它主要实现监听ServletContext的创建和删除。ServletContextListener接口提供了两个方法，他们也为称为“Web应用程序的生命周期方法”
 *          contextInitialized(ServletContextEvent event)方法：通知正在收听的对象，应用程序以及被加载及初始化。
 *          contextDestroyed(servletContextEvent event)方法：通知正在收听的对象，应用程序已经被载出，即关闭。
 *      ServletContextAttributeListener接口：该接口存放在javax.servlet包内，主要实现监听ServletContext属性的增加、删除和修改。ServletAttributeListener接口提供了3个方法
 *          attributeAdded(ServletContextAttributeEvent event)方法：当有对象加入Application的范围时，通知正在收听的对象。
 *          attributeReplaced(ServletContextAttributeEvent event)方法：当在Application的范围有对象取代另一个对象时。通知正在收听的对象。
 *          attributeRemoved(ServletContextAttributeEvent event)方法：当有对象从Application的范围移除时，通知正在收听的对象。
 * HTTP会话监听：有4个接口可以进行监听
 *      HttpSessionListener接口：HttpSessionListener接口实现监听HTTP会话创建、销毁。HttpSessionListener接口提供了两个方法。
 *          sessionCreated(HttpSessionEvent event)方法：通知正在收听的对象，session已经被加载及初始化。
 *          sessionDestroyed(HttpSessionEvent event)：通知正在收听的对象，session已经被载出。
 *      注：HttpSessionEvent类的主要方法getSession(), 可以使用该方法回传一个session对象。
 *      ServletContextAttributeListener接口实现监听HTTP会话active和passivate。HttpSessionActivationListener接口提供了以下3个方法
 *          attributeAdded(HttpSessionBindingEvent event)方法：当有对象加入session的范围时，通知正在收听的对象。
 *          attributeReplaced(HttpSessionBindingEvent event)方法：当在session的范围有对象取代另一个对象时，通知正在收听的对象
 *          attributeRemoved(HttpSessionBindingEvent event)方法：当有对象从session的范围移除时，通知正在收听的对象
 *      注：HttpSessionBindingEvent类主要有三个方法：getName()、getSession()和getValues()
 *      HttpSessionBindingListener接口:HttpSessionBindingListener接口实现监听HTTP会话中对象的绑定信息，它不需要在web.xml文件中设定Listener的。
 *          valueBound(HttpSessionBindingEvent event)方法：当有对象加入session的范围时会自动调用。
 *          valueUnBound(HttpSessionBindingEvent event)方法：当有对象从session的范围移除时会被自动调用。
 *      HttpSessionActivationListener接口：HttpSessionActivationListener接口实现监听HTTP会话中属性的设置请求。它不需要在web.xml文件中设定Listener的。
 *          sessionDidActivate(HttpSessionEvent event)方法：通知正在收听的对象，它的session已经变为有效状态。
 *          sessionWillPassivate(HttpSessionEvent event)方法：通知正在收听的对象，它的session已经变成无效状态。
 * Servlet请求监听
 *      ServletRequestListener接口
 *          requestInitialized(ServletRequestEvent event)方法：通知正在收听的对象，ServletRequest已经被加载及初始化。
 *          requestDestroyed(ServletRequestEvent event)方法：通知正在收听的对象，ServletRequest已经被载出，即关闭
 *      ServletRequestAttributeListener接口
 *          attributeAdded(ServletRequestAttributeEvent event)方法：当对对象加入request的范围时，通知正在收听的对象。
 *          attributeReplaces(ServletRequestAttributeEvent event)方法：当在request的范围内有对象取代另一个对象时，通知正在收听的对象。
 *          attributeRemoved(ServletRequestAttributeEvent event)方法：当有对象从request的范围移除时，通知正在收听的对象。
 *
 *
 * Servlet监听器的配置
 * 要让Web容器在Web应用程序启动时通知MyServletContextListener,需要再web.xml文件中使用<listener>元素来配置监听器类。
 *
 *
 * @author bigDragon
 * @create 2020-09-23 16:48
 */
public class ListenerMain {
    public static void main(String[] args){
        //Servlet上下文监听
        //ServletContextListener接口
        new ServletContextListenerTest();
        //ServletContextAttributeListener接口
        new ServletContextAttributeListenerTest();

        //HTTP会话监听
        //HttpSessionListener接口
        new HttpSessionListenerTest();
        //ServletContextAttributeListener接口
        new ServletContextAttributeListenerTest();
        //HttpSessionActivationListener接口
        new HttpSessionActivationListenerTest("");
        //HttpSessionBindingListener接口
        new HttpSessionBindingListenerTest("");


        //Servlet请求监听
        //ServletRequestListener接口
        new ServletRequestListenerTest();
        //ServletRequestAttributeListener接口
        new ServletRequestAttributeListenerTest();
    }
}
