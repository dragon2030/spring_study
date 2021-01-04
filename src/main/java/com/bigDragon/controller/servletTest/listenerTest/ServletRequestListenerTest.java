package com.bigDragon.controller.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 监听HttpServletRequest对象的创建及销毁
 *  ServletRequestListener接口
 *      requestInitialized(ServletRequestEvent event)方法：通知正在收听的对象，ServletRequest已经被加载及初始化。
 *      requestDestroyed(ServletRequestEvent event)方法：通知正在收听的对象，ServletRequest已经被载出，即关闭
 *
 * @author bigDragon
 * @create 2020-09-24 16:49
 */
public class ServletRequestListenerTest implements ServletRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(ServletRequestListenerTest.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 可以获取request对象, 获取request对象中的共享数据
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long costTime = System.currentTimeMillis() - (Long) request.getAttribute("startTime");
        logger.warn("本次请求耗时：" + costTime + " ms");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String uri = request.getRequestURI();
        uri= request.getQueryString() == null?uri : (uri + "?" + request.getQueryString());
        logger.warn("请求的uri为：" + uri);
        // 可以向request对象中放入这次请求中共享的数据
        request.setAttribute("startTime", System.currentTimeMillis());
    }
}
