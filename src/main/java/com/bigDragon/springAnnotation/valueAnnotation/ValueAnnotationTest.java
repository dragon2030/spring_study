package com.bigDragon.springAnnotation.valueAnnotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Value
 *通过@Value将外部的值动态注入到Bean中，使用的情况有：
 * 常量注入
 * @Value("")
 * bean属性、系统属性、表达式注入
 * @Value("#{}")
 * 配置文件属性注入
 * @Value("${}")
 *
 * @author bigDragon
 * @create 2021-02-20 11:14
 */
@Controller
@RequestMapping("/valueAnnotation")
public class ValueAnnotationTest {

    private static Logger logger = LoggerFactory.getLogger(ValueAnnotationTest.class);

    @Value("Hello World")
    private String st1;//注入普通字符串

    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName; // 注入操作系统属性

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果

    @Value("#{dataSource.driverClassName}")
    private String fromAnotherBean; // 注入其他Bean属性

    //@Value("classpath:jdbc.properties")
    private Resource resourceFile; // 注入文件资源

    //@Value("http://www.baidu.com")
    private Resource testUrl; // 注入URL资源

    @Value("${jdbc.url}")
    private String url; //配置文件属性注入

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        logger.info("注入普通字符串:"+st1);
        logger.info("注入操作系统属性:"+systemPropertiesName);
        logger.info("注入表达式结果:"+randomNumber);
        logger.info("注入其他Bean属性:"+fromAnotherBean);
        //logger.info("注入文件资源:"+resourceFile.description());
        //logger.info("注入URL资源:"+testUrl.description());
        logger.info("配置文件属性注入："+url);
        return url;
    }
}
