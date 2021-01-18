package com.bigDragon.servletTest.ServletNewFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet异步处理
 *
 * 异步处理是Servlet3.0最重要的内容之一。在此之前，一个Servlet的工作流程是：首先，Servlet接收到请求后，需要对请求携带的数据进行一些预处理。接着调用业务接口的某些方法，以完成业务处理。最后，
 * 根据处理的结果提交相应，至此，Servlet线程结束。在此过程中，如果任何一个任务没有结束，Servlet线程就处于阻塞状态，知道业务方法执行完毕。对于较大的应用，很冗余造成程序性能的降低。
 *
 * Servlet3.0针对这一问题做出了突破性的工作，现在通过使用Servlet3.0的异步处理机制可以将之前的Servlet处理流程调整为以下过程。首先，Servlet接收到请求之后，可能需要对请求携带的数据进行一些
 * 预处理；接着Servlet线程将请求转交给一个异步线程来执行业务处理，线程本身返回容器，此时Servlet还没有生成响应的数据，异步线程处理完业务之后，可以直接生成响应数据，或者将请求继续转发给其他
 * Servlet。这样，Servlet线程不再是一直处于阻塞状态以等待业务逻辑的处理，而是启动异步之后可以立即返回。
 *
 * 异步处理机制可以应用于Servlet和过滤器两种组件，由于异步处理的工作模式与普通工作模式有着本质区别，在默认情况下，并没有开启异步处理特性，如果希望使用该特性，必须按如下方法启动：
 *      1.@WebServlet 和 @WebFilter注释提供了asyncSupported属性，默认该属性的取值为false，要启动异步处理支持，只需将属性设置为true即可。
 *      2.如果选择在web.xml文件中对Servlet或者过滤器进行配置，可以再Servlet3.0为<servlet>和<filter>标签中增加<async-supported>子标签，该标签的默认取值为false，要启动异步处理支持，则将其
 *      设置为true即可
 *
 *  同步监听器
 *  除了Servlet和Filter执行异步操作之外，Servlet 3.0还新增了一个AsyncListener接口，以便通知用户在异步处理期间
 *  AsyncListener接口定义的方法：
 *      void onStartAsync(AsyncEvent event)   在刚启动一个异步操作时调用
 *      void onComplete(AsyncEvent event)   当一个异步操作已经完成时调用
 *      void onError(AsyncEvent event)   当一个异步操作失败是调用
 *      void onTimeout(AsyncEvent event)   当一个异步操作已经超时的时候调用
 *
 * 发生的情况。
 * @author bigDragon
 * @create 2020-09-29 10:49
 */
@WebServlet(name = "servletAsynchronousProcessing",urlPatterns = "/ServletAsynchronousProcessing",asyncSupported = true)
public class ServletAsynchronousProcessing extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ServletAsynchronousProcessing.class);
    //初始化方法
    public void init() throws ServletException{
        logger.warn("ServletAsynchronousProcessing初始化");
    }
    //销毁方法
    public void destroy(){
        super.destroy();
        logger.warn("ServletAsynchronousProcessing销毁");
    }
    //处理HTTP Get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html");
        final PrintWriter write=resp.getWriter();
        write.println("<html><head><title>"
                +"Async Servlet</title></head>");
        write.println("<body><div id='progress'></div>");
        final AsyncContext asyncContext=req.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("new Thread:"+Thread.currentThread());
                for(int i=0;i<10;i++){
                    write.println("<script>");
                    write.print("document.getElementById('progress').innerHTML='"
                            +(i*10)+"% complete'");
                    write.println("</script>");
                    write.flush();
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){}
                }
                write.println("<script>");
                write.println("document.getElementById('progress').innerHTML='DONE'");
                write.println("</script>");
                write.println("</body></html>");
                asyncContext.complete();
            }
        });
    }

}
