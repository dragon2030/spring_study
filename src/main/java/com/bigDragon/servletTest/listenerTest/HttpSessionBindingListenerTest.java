package com.bigDragon.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/** 实现了HttpSessionBindingListener接口的JavaBean对象可以感知自己被绑定到Session中和从Session中删除的事件
 *  HttpSessionBindingListener接口:HttpSessionBindingListener接口实现监听HTTP会话中对象的绑定信息，它是不需要再web.xml文件中设定Listener的。HttpBindingListener接口提供了以下两个方法。
 *          valueBound(HttpSessionBindingEvent event)方法：当有对象加入session的范围时会自动调用。
 *          valueUnBound(HttpSessionBindingEvent event)方法：当有对象从session的范围移除时会被自动调用。
 *
 *  valueUnbound的触发条件是以下三种情况：
 * 1. 执行session.invalidate()时。
 * 2. session超时，自动销毁时。
 * 3. 执行session.setAttribute(“onlineUserListener”, “其他对象”);或session.removeAttribute(“onlineUserListener”);将listener从session中删除时。
 * @author bigDragon
 * @create 2020-09-25 19:20
 */
public class HttpSessionBindingListenerTest implements HttpSessionBindingListener {
    private static final Logger logger = LoggerFactory.getLogger(HttpSessionBindingListenerTest.class);
    private String name;

    public HttpSessionBindingListenerTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // JavaBean被加到session中触发
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        logger.warn(name + "被加到session中了...");
    }

    // 从session中移除JavaBean时触发
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logger.warn(name + "从session中被移除了...");
    }
}
