package com.bigDragon.springAOP.aspectJDemo;

/**
 * AspectJ 支持 5 种类型的通知注解:
 * @Before: 前置通知, 在方法执行之前执行
 * @After: 后置通知, 在方法执行之后执行
 * @AfterRunning: 返回通知, 在方法返回结果之后执行
 * @AfterThrowing: 异常通知, 在方法抛出异常之后
 * @Around: 环绕通知, 围绕着方法执行
 *
 * @author bigDragon
 * @create 2021-01-18 17:17
 */
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

//@Component
//@Aspect
public class SleepHelper {

    private static final Logger logger = LoggerFactory.getLogger(SleepHelper.class);

    // 保存方法开始执行时间
    private final ThreadLocal<Long> tlo = new ThreadLocal<>();

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     */
    @Pointcut("execution(* com.bigDragon.springAOP..*.sleep(..))")
    public void declareJointPointExpression(){}

    // 前置通知, 在方法执行之前执行
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        try {
            String methodName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
            Object [] args = joinPoint.getArgs();
            StringBuffer params = new StringBuffer();
            for(int i = 0;i < args.length;i++){
                if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse
                        || args[i] instanceof MultipartFile) {
                    continue;
                }
                String param = JSON.toJSONString( args[ i ] );
                params.append( params.length() == 0 ? "" : "," );
                params.append( param );
            }
            if (!params.toString().startsWith( "{" )) {
                params.insert( 0, "{" ).append( "}" );
            }
            // 记录方法开始执行的时间戳
            tlo.set( System.currentTimeMillis() );
            logger.info( "--服务调用开始-- 方法名：" + methodName + " 入参：" + params.toString() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 后置通知，在方法执行之后执行的代码. 无论该方法是否出现异常
     */
    //@After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
    }

    /**
     * 在方法法正常结束受执行的代码
     * 返回通知是可以访问到方法的返回值的!
     */
    @AfterReturning(value="declareJointPointExpression()",returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        try {
            // 计算方法执行的耗时
            long time = System.currentTimeMillis() - tlo.get();
            String cmName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
            // 如果执行时间过短，睡眠1ms，防止日志顺序错乱
            if(time == 0) {
                Thread.sleep(1L);
            }
            logger.info("--服务调用结束--，耗时【" + (time == 0 ? "< 1" : time) + "】毫秒---------------- 方法名：" + cmName + " 出参：" + JSON.toJSONString( result ));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在目标方法出现异常时会执行的代码.
     * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
     */
   @AfterThrowing(value="declareJointPointExpression()",throwing="e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        String cmName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       e.printStackTrace(new PrintStream(baos));
       String exception = baos.toString();
       logger.error("--服务调用异常--：" + exception);
    }

/**
 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
 */
    //@Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd){

        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }
}