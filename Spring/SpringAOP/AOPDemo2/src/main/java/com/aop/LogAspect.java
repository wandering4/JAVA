package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 */
/*@Aspect //被该注解修饰的为切面类*/
@Component
public class LogAspect {

    //如果一个切点表达式被多次使用，可以单独定义一个切点表达式
//    @Pointcut("execution(* com.service.impl.*.*(..))")
    public void pointCut(){

    }

//    @Before("execution(public int  com.service.impl.CalculateImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //前置通知
        System.out.println("前置通知执行了");
        String name = joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());
        System.out.println("执行方法的相关信息："+name+",参数:"+args);
    }

    /**
     * 后置通知:可以获取目标方法的返回结果
     */
//    @AfterReturning(value = "pointCut()",returning = "res")
    public void afterReturning(JoinPoint joinPoint,Object res){
        String name = joinPoint.getSignature().getName();
        System.out.println("后置通知:"+name+"，返回结果:"+res);
    }

    /**
     * 环绕通知
     * 必须匹配执行方法的返回结果
     */
//    @Around("execution(* com.service.impl.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Object obj=null;
        try {
            System.out.println("环绕通知执行之前");
            obj=joinPoint.proceed();
            System.out.println("环绕通知执行之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知执行异常");
        } finally {
            System.out.println("环绕通知执行最终完成");
        }
        return obj;
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param ex
     */
//    @AfterThrowing(value = "execution(* com.service.impl.*.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知:"+methodName+" "+ex);
    }

    /**
     * 最终通知
     * @param joinPoint
     */
//    @After(value = "execution(* com.service.impl.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("最终通知执行了:"+name);

    }
}
