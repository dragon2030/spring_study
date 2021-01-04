package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 监听Context对象的创建及销毁
 *  ServletContextListener接口：该接口存放在javax.servlet包内，它主要实现监听ServletContext的创建和删除。ServletContextListener接口提供了两个方法，他们也为称为“Web应用程序的生命周期方法”
 *      contextInitialized(ServletContextEvent event)方法：通知正在收听的对象，应用程序以及被加载及初始化。
 *      contextDestroyed(servletContextEvent event)方法：通知正在收听的对象，应用程序已经被载出，即关闭。
 *
 * @author bigDragon
 * @create 2020-09-24 10:31
 */
public class ServletContextListenerTest implements ServletContextListener{

    private static final Logger logger = LoggerFactory.getLogger(ServletContextListenerTest.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("web容器启动, context对象被创建...");
        // 可以获取 context对象
        ServletContext context = sce.getServletContext();
        logger.warn("即将启动 " + context.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("web容器关闭, context对象被销毁...");
        // 可以获取 context对象
        ServletContext context = sce.getServletContext();
        logger.warn("即将关闭 " + context.getContextPath());
    }
}
