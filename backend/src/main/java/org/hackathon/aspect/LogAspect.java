package org.hackathon.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before(value = "execution(* org.hackathon.controller.*Controller.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(String.format("AOP %-6s --> class %s, method %s, arguments %s", "before", className, methodName, args));
    }

    @AfterReturning(value = "execution(* org.hackathon.controller.*Controller.*(..))", returning = "returning")
    public void doAfterReturning(JoinPoint joinPoint, Object returning) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        if (returning instanceof ResponseEntity) {
            ResponseEntity<?> response = (ResponseEntity<?>) returning;
            String responseBody = response.getBody().toString();
            logger.info(String.format("AOP %-6s --> class %s, method %s, result %s", "after", className, methodName, responseBody));
        } else {
            logger.info(String.format("AOP %-6s --> class %s, method %s, result %s", "after", className, methodName, returning));
        }
    }
}
