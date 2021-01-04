package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *  监听Session对象属性的变化
 *  HttpSessionAttributeListener
 *  HttpSessionActivationListener接口实现监听HTTP会话active和passivate。HttpSessionActivationListener接口提供了以下3个方法
 *     attributeAdded(HttpSessionBindingEvent event)方法：当有对象加入session的范围时，通知正在收听的对象。
 *     attributeReplaced(HttpSessionBindingEvent event)方法：当在session的范围有对象取代另一个对象时，通知正在收听的对象
 *     attributeRemoved(HttpSessionBindingEvent event)方法：当有对象从session的范围移除时，通知正在收听的对象
 * @author bigDragon
 * @create 2020-09-24 18:47
 */
public class HttpSessionAttributeListenerTest implements HttpSessionAttributeListener {

    private static final Logger logger = LoggerFactory.getLogger(HttpSessionAttributeListenerTest.class);

    // 向session中添加属性时触发
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String key = event.getName();
        Object value = event.getValue();
        logger.warn("向id = " + session.getId() + " 的session中添加的属性为 <" + key + "," + value + ">");
    }

    // 从session中移除属性时触发
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String key = event.getName();
        Object value = event.getValue();
        logger.warn("从id = " + session.getId() + " 的session中移除的属性为 <" + key + "," + value + ">");
    }

    // 修改session中属性时触发
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String key = event.getName();
        logger.warn("修改id = " + session.getId() + " 的session的属性为  key = " + key);
    }
}
