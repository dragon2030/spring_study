package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 监听ServletRequest对象属性的变化
 *  ServletRequestAttributeListener接口
 *      attributeAdded(ServletRequestAttributeEvent event)方法：当对对象加入request的范围时，通知正在收听的对象。
 *      attributeReplaces(ServletRequestAttributeEvent event)方法：当在request的范围内有对象取代另一个对象时，通知正在收听的对象。
 *      attributeRemoved(ServletRequestAttributeEvent event)方法：当有对象从request的范围移除时，通知正在收听的对象。
 *
 * @author bigDragon
 * @create 2020-09-25 17:12
 */
public class ServletRequestAttributeListenerTest implements ServletRequestAttributeListener {

    private static final Logger logger = LoggerFactory.getLogger(ServletRequestAttributeListenerTest.class);

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        ServletRequest servletRequest = event.getServletRequest();
        //获取添加的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("servletRequest范围内添加了名为"+name+"值为"+value+"的属性");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        ServletRequest servletRequest = event.getServletRequest();
        //获取被删除的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("servletRequest范围内名为"+name+"值为"+value+"的属性被删除了");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        ServletRequest servletRequest = event.getServletRequest();
        //获取被替换的属性名和属性值
        String name=event.getName();
        Object value=event.getValue();
        logger.warn("servletRequest范围内"+name+"值为"+value+"的属性被替换了");

    }
}
