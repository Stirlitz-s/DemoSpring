package com.stsoft.demospring.aspect;
import com.stsoft.demospring.entity.Task;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
   // @Pointcut("execution(public * *(..))")
    @Pointcut("execution(* *.addTask(..))")
    public void callAtMyServicePublic() {
        System.out.println("Before11");
      
    }
    @Before("callAtMyServicePublic()")
    public void logBeforeHello() {
        System.out.println("Before");
    }
    @After(value="execution(* *.addTask(..))")
    public void logAfterHello(JoinPoint joinPoint) {
    	System.out.println("After " + joinPoint.getKind());
    	System.out.println("After " + ((Task)joinPoint.getArgs()[2]).getDescription());
    	System.out.println("After " + joinPoint.getSignature());
    }
   /* @After("callAtMyServicePublic()")
    public void logAfterHello() {
        System.out.println("After");
    }*/
}

