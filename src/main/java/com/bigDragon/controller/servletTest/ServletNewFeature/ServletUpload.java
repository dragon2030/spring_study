package com.bigDragon.controller.servletTest.ServletNewFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet对 文件传世的支持
 * 实现Servlet3.0文件上传需要以下两项内容：
 *      1.需要添加@MultipartConfig注释
 *      2.从request对象中获取Part文件对象
 * @MultipartConfig 注释需要标注在@WebServlet注释之上。具有的属性如下
 *      fileSizeThreshold：当数据量大于该值时，内容将被写入文件
 *      location：存放生成的文件地址
 *      maxFileSize：运行上传的文件最大值。默认值为-1，表示没有限制
 *      maxRequestSize：针对multipart/from-data请求的最大数量，默认值为-1，表示没有限制
 * 除了要配置@MultipartConfig注解之外，还需要两个重要的方法，即getPart()与getParts()方法。下面对这两个方法做详细介绍。
 *      Part getPart(String name)
 *      Collection<Part>getParts()
 *      getPart()方法的name参数表示请求的name文件。getParts() 方法可获取请求中所有文件。上传文件用javax.servlet.http.Part对象来表示。Part接口提供了处理文件的简易方法，如write()、
 *      delete()等
 *
 *  遗留问题：未完成 等之后看过io源码之后 在对上传下载进行对比书写
 * @author bigDragon
 * @create 2020-09-30 16:26
 */
@WebServlet("/ServletUpload")
@MultipartConfig(location = "d:/tmp")
public class ServletUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = this.getServletContext().getRealPath("/");    //获取服务器地址
        Part p = request.getPart("file1");                   //获取用户选择的上传文件
        if(p.getContentType().contains("image")){                   //仅处理上传的图像文件
            String fname1 = p.getName();
            p.write(path+"/resources/upload/"+fname1);              //写入Web项目根路径下的upload文件夹中
            out.write("文件上传成功");
        }else{
            out.write("请选择图片文件");
        }
    }
}
