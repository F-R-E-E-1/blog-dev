package com.jucwang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    //这个注解代表这是一个切入点,execution()表示需要拦截
    //controller下的所有类和方法
    @Pointcut("execution(* com.jucwang.web.*.*(..))")
    public void Log(){

    }

    @Before("Log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("***********before***********");
        //attributes 可以获得requetst的信息
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获得请求的request
        HttpServletRequest request = attributes.getRequest();
        //获取url
        String url = request.getRequestURL().toString();
        //获取ip地址
        String ip = request.getRemoteAddr();
        //获取封装方法
        /*
        目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        目标方法名为:" + joinPoint.getSignature().getName());
        * */
        String classMethod = joinPoint
                .getSignature().
                getDeclaringTypeName()
                +"."+
                joinPoint
                        .getSignature()
                        .getName();
        //获取传入方法的参数
        Object[] args = joinPoint.getArgs();
        //封装到dto中
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);
        logger.info("Request:{}",requestLog);

    }
    @After("Log()")
    public void doAfter(){
        logger.info("--------------------请求信息输出完成------------");
    }
    //捕获返回的内容
    @AfterReturning(returning = "result",pointcut = "Log()")
    public void afterReturn(Object result){
        logger.info("result: {}",result);

    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object args;

        public RequestLog(String url, String ip, String classMethod, Object args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + args +
                    '}';
        }
    }


}
