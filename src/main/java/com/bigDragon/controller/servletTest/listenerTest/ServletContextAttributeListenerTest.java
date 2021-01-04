package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听ServletContext对象属性的变化
 *  ServletContextAttributeListener接口：该接口存放在javax.servlet包内，主要实现监听ServletContext属性的增加、删除和修改。ServletAttributeListener接口提供了3个方法
 *      attributeAdded(ServletContextAttributeEvent event)方法：当有对象加入Application的范围时，通知正在收听的对象。
 *      attributeReplaced(ServletContextAttributeEvent event)方法：当在Application的范围有对象取代另一个对象时。通知正在收听的对象。
 *      attributeRemoved(ServletContextAttributeEvent event)方法：当有对象从Application的范围移除时，通知正在收听的对象。
 *
 * @author bigDragon
 * @create 2020-09-24 10:42
 */

//@WebListener
public class ServletContextAttributeListenerTest implements ServletContextAttributeListener{

    private static final Logger logger = LoggerFactory.getLogger(ServletContextAttributeListenerTest.class);

    //把一个属性存入application范围时触发该方法
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext servletContext = event.getServletContext();
        //获取添加的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("ServletContext范围内添加了名为"+name+"值为"+value+"的属性");
    }

    //把一个属性从application范围删除时触发该方法
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContext application=event.getServletContext();
        //获取被删除的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("ServletContext范围内名为"+name+"值为"+value+"的属性被删除了");
    }

    //替换application范围内的属性时触发该方法
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContext application=event.getServletContext();
        //获取被替换的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("ServletContext范围内"+name+"值为"+value+"的属性被替换了");
    }
}
