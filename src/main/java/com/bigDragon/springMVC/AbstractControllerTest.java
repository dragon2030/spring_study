package com.bigDragon.springMVC;

import com.bigDragon.model.User1;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AbstractController将在spring请求时运行
 * @author bigDragon
 * @create 2020-09-14 15:19
 */
public class AbstractControllerTest extends AbstractController {
    public User1 user1;

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OtherBeanInjection类中handleRequestInternal方法执行了");
        //System.out.println(user1.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}
