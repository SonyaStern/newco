package com.andreitop.newco.aspect;


import com.andreitop.newco.service.TripService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @AfterReturning("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void afterRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " was called right now");
    }

    @Before("com.ps.aspects.PointcutContainer.serviceDelete(service, id)")
    public void beforeServiceDelete(TripService service, Long id) {
        logger.info(" ---> Target object " + service.getClass());
    }

    @AfterReturning(value="execution (com.ps.aspects.PointcutContainer.serviceDelete(service, id))", returning = "result")
    public void afterServiceDelete(JoinPoint joinPoint, int result) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        if(result == 0) {
            logger.info(" ---> Delete method " + className + "." + methodName + " performed as expected.");
        }
    }

    @Around("com.ps.aspects.PointcutContainer.serviceDelete(service, id)")
    public Object monitorDelete(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Intercepting call of: " + methodName);
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
            return joinPoint.proceed();
        } finally {
            long t2 = System.currentTimeMillis();
            logger.info(" ---> Execution of " + methodName + " took: " + (t2 - t1) / 1000 + " ms.");
        }
    }

    @Around("com.ps.aspects.PointcutContainer.serviceMethods()")
    public Object monitorService(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Intercepting call of: " + methodName);
        long t1 = System.currentTimeMillis();
        try {
            Thread.sleep(1000L);
            return joinPoint.proceed();
        } finally {
            long t2 = System.currentTimeMillis();
            logger.info(" ---> Execution of " + methodName + " took: " + (t2 - t1) / 1000 + " ms.");
        }
    }

}
