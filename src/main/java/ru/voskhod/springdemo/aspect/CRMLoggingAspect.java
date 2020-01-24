package ru.voskhod.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* ru.voskhod.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* ru.voskhod.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* ru.voskhod.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display the method we are calling
        logger.info("====>> in @Before: The method is: "
                + joinPoint.getSignature().toShortString());

        // display the arguments to the method
        for (Object arg : joinPoint.getArgs()) {
            logger.info("====>> argument: " + arg);
        }
    }

    // add @AfterReturning advice

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // display method we are returning from
        logger.info("====>> in @AfterReturning: The method is: "
                + joinPoint.getSignature().toShortString());

        // display data returned
        logger.info("====>> result: " + result);
    }

}
