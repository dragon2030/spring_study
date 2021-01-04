package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session对象的创建及销毁
 *  HttpSessionListener接口：HttpSessionListener接口实现监听HTTP会话创建、销毁。HttpSessionListener接口提供了两个方法。
 *      sessionCreated(HttpSessionEvent event)方法：通知正在收听的对象，session已经被加载及初始化。
 *      sessionDestroyed(HttpSessionEvent event)：通知正在收听的对象，session已经被载出。
 *
 * @author bigDragon
 * @create 2020-09-24 17:12
 */
public class HttpSessionListenerTest implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(HttpSessionListenerTest.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 可以获取session对象
        HttpSession session = se.getSession();
        logger.warn("新创建一个session, id = " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 可以获取session对象
        HttpSession session = se.getSession();
        logger.warn("销毁一个session, id = " + session.getId());
    }
}
