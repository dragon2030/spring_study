package com.bigDragon.controller.servletTest.ServletNewFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener
 * WebListener注解用于声明监听器，还可以用于充当给定Web应用上下文中各种Web应用事件的监听器的类。可以使用@WebListener来标注一个实现ServletContextListener、ServletContextAttributeListener/
 * ServletRequestListener、ServletRequestAttributeListener、HttpSessionListener、HttpSessionAttributeListener等的类。@WebListener注释有一个value属性，该属性为可选属性，用于描述监听器
 * 信息。
 *
 * @author bigDragon
 * @create 2020-09-28 21:00
 */
/*@WebListener*/
public class WebListenerTest implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(WebListenerTest.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.warn("WebListenerTest监听器ServletContext初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.warn("WebListenerTest监听器ServletContext销毁");
    }
}
