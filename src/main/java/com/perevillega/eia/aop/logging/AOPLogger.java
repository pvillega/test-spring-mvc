package com.perevillega.eia.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Cross concert logging, added to experiment with AOP pointcuts
 */
@Aspect
public class AOPLogger {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut(value = "execution(public * *(..))")
    private void anyPublicOperation() {
    }

    @Pointcut(value = "execution(* com.perevillega.eia..*(..))")
    private void anyObject() {
    }

    @Before(value = "anyPublicOperation() && anyObject()")
    public void logBefore(JoinPoint point) {
        String msg = "calling [%s]([%s]) from [%s]";
        log.debug(String.format(msg, point.getSignature().getName(), Arrays.toString(point.getArgs()), point.getSourceLocation()));
    }

    @AfterReturning(value = "anyPublicOperation() && anyObject()", returning = "returnVal")
    public void logReturn(JoinPoint point, Object returnVal) {
        String msg = "called [%s]([%s]) returning [%s] from [%s]";
        log.debug(String.format(msg, point.getSignature().getName(), Arrays.toString(point.getArgs()), returnVal, point.getSourceLocation()));
    }

    @AfterThrowing(value = "anyPublicOperation() && anyObject()", throwing = "exception")
    public void logException(JoinPoint point, Throwable exception) {
        String msg = "EXCEPTION [%s]([%s]): [%s]";
        log.error(String.format(msg, point.getSignature().getName(), Arrays.toString(point.getArgs()), exception.getLocalizedMessage()), exception);
    }


}
