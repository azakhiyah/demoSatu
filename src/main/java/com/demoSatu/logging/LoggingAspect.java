package com.demoSatu.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.demoSatu.model.Menu;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.demoSatu.service.MenuService.saveMenu(..)) && args(menu)")
    public void logBefore(Menu menu) {
        System.out.println("Log Before: About to execute saveMenu. Menu Name: " + menu.getMenuName());
    }

     @After("execution(* com.demoSatu.service.MenuService.saveMenu(..))")
    public void logAfter() {
        System.out.println("Log After: Finished executing saveMenu.");
    }

    @AfterReturning(pointcut = "execution(* com.demoSatu.service.MenuService.saveMenu(..))", returning = "result")
    public void logAfterReturning(Menu result) {
        System.out.println("Log After Returning: Menu saved successfully. Menu Name: " + result.getMenuName());
    }

    @AfterThrowing(pointcut = "execution(* com.demoSatu.service.MenuService.saveMenu(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("Log After Throwing: Exception occurred while executing saveMenu. Message: " + exception.getMessage());
    }
    
}
