package com.bigDragon.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 实现了HttpSessionActivationListener接口的JavaBean对象可以感知自己被活化(反序列化)和钝化(序列化)的事件
 *  HttpSessionActivationListener接口：HttpSessionActivationListener接口实现监听HTTP会话中属性的设置请求。它不需要再web.xml文件中设定Listener的。
 *          sessionDidActivate(HttpSessionEvent event)方法：通知正在收听的对象，它的session已经变为有效状态。
 *          sessionWillPassivate(HttpSessionEvent event)方法：通知正在收听的对象，它的session已经变成无效状态。
 *
 * @author bigDragon
 * @create 2020-09-25 19:30
 */
public class HttpSessionActivationListenerTest implements HttpSessionActivationListener,Serializable {
    private static final Logger logger = LoggerFactory.getLogger(HttpSessionActivationListenerTest.class);
    private static final long serialVersionUID = 1L;

    private String name;

    public HttpSessionActivationListenerTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HttpSessionActivationListenerTest{" +
                "name='" + name + '\'' +
                '}';
    }

    // 钝化前触发
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        logger.warn(name + "将要和session一起被序列化(钝化)到硬盘, session id = "+se.getSession().getId());
    }

    // 活化后触发
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        logger.warn(name + "和session一起从硬盘反序列化(活化)回到内存了, session id = "+se.getSession().getId());
    }
}
