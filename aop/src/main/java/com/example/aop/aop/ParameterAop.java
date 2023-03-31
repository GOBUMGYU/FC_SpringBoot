package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //자바에서 널리 사용되는 AOP,  프레임워크에 포함되며, AOP 정의하는 Class에 할당
@Component
public class ParameterAop {

    //기능을 어디에 적용 시킬지, 메소드|Annotation 등 AOP를 적용시킬 지점 설정
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    //cut이 실행되기 전 before메서드를 실행
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("type : "+obj.getClass().getSimpleName());
            System.out.println("value : "+obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return Obj");
        System.out.println(returnObj);
    }
}
