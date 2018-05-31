package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DefaultAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切入点，可以通过@Around，@Before等在切入点前后执行代码逻辑
     */
    @Pointcut("execution(String com.example.demo.controller.TestController.log())")
    public void demoPointcut(){}

    /**
     * 把自定义注解定义为一个切入点
     */
    @Pointcut("@annotation(com.example.demo.annotation.TestAnnotation)")
    public void testAnnotationPointcut(){}

    @Before("testAnnotationPointcut()")
    public void beforeTestAnnotationPointcut(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("进入Aspect的Before,方法名是：" + methodName + ",自定义注解是@TestAnnotation");
    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("demoPointcut()")
    public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        logger.info("进入Aspect的Around,方法名是：" + methodName);
        Object o = pjp.proceed();
        logger.info("离开Aspect的Around,方法名是：" + methodName);
        return o;
    }

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param jp
     */
    @Before("demoPointcut()")
    public void beforeAspect(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("进入Aspect的Before,方法名是：" + methodName);
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    @After("demoPointcut()")
    public void afterAspect(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("进入Aspect的After,方法名是：" + methodName);
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     */
    @AfterReturning("demoPointcut()")
    public void afterReturningAspect(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("进入Aspect的AfterReturning,方法名是：" + methodName);
    }

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     * @param jp
     */
    @AfterThrowing("demoPointcut()")
    public void afterThrowingAspect(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("进入Aspect的AfterThrowing,方法名是：" + methodName);
    }


}
