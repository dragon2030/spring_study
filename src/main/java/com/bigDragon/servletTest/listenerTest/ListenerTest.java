package com.bigDragon.servletTest.listenerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet监听器测试类
 * @author bigDragon
 * @create 2020-09-24 19:02
 */
public class ListenerTest extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ListenerTest.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

/*        //监听ServletContext对象属性的变化测试验证
        servletContext.setAttribute("name","Jack");
        logger.warn("ListenerTest类执行，ServletContext添加属性[name：name value:Jack");
        servletContext.setAttribute("name","Mike");
        logger.warn("ListenerTest类执行，ServletContext添加属性[name：name value:Mike");
        servletContext.removeAttribute("name");
        logger.warn("ListenerTest类执行，ServletContext添加属性[name：name");

        //监听Session对象属性的变化测试验证
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name","Jack");
        logger.warn("ListenerTest类执行，添加session[id:+"+httpSession.getId()+" name：name value:Jack");
        httpSession.setAttribute("name","Mike");
        logger.warn("ListenerTest类执行，修改session[id:+"+httpSession.getId()+" name：name value:Mike");
        httpSession.removeAttribute("name");
        logger.warn("ListenerTest类执行，移除session[id:+"+httpSession.getId()+" name：name");

        //监听ServletRequest对象属性的变化测试验证
        req.setAttribute("name","Jack");
        logger.warn("ListenerTest类执行，ServletRequest添加属性[name：name value:Jack");
        req.setAttribute("name","Mike");
        logger.warn("ListenerTest类执行，ServletRequest添加属性[name：name value:Mike");
        req.removeAttribute("name");
        logger.warn("ListenerTest类执行，ServletRequest添加属性[name：name");*/

/*        //监听HttpSessionBindingListener对自身绑定的感知测试
        HttpSessionBindingListenerTest httpSessionBindingListenerTest=new HttpSessionBindingListenerTest("Mike");
        //servletContext.setAttribute("HttpSessionBindingListener",httpSessionBindingListenerTest);
        //logger.warn("HttpSessionBindingListener测试 已添加到servletContext");
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("HttpSessionBindingListener",httpSessionBindingListenerTest);
        logger.warn("HttpSessionBindingListener测试 已添加到HttpSession");*/

    }
}
