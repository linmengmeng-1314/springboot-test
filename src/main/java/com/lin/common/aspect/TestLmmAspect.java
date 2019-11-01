package com.lin.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component 
@Order(Integer.MIN_VALUE)
public class TestLmmAspect {

	@Pointcut("@annotation(com.lin.common.annotation.TestLmm)")
	public void testPointCut() {
		
	}
	
//	@Before("testPointCut()")
//	public void before(JoinPoint point) {
//		System.out.println("成功调用@Before注解的方法");
//	}
	@Around("testPointCut()")
	public Object around(ProceedingJoinPoint point) {
		Object result = point.getTarget();
		System.out.println("成功调用@Around注解的方法");
		return result;
	}
//	@After("testPointCut()")
//	public void after(JoinPoint point) {
//		System.out.println("成功调用@After注解的方法");
//	}
	
}
