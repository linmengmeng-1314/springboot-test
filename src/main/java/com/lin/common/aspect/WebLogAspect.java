package com.lin.common.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 统一日志处理切面
 * @author linmengmeng
 * @data 2019年7月12日上午11:26:32
 */

@Aspect
@Component
@Order(-1)
public class WebLogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);
	
	@Pointcut("execution(public * com.lin.models.controller.*.*(..))")
	public void webLog() {
		
	}
	
	@Before("webLog()")
	public void doBefore(Joinpoint joinpoint) throws Throwable{
		
	}
	
	@AfterReturning(value = "webLog()", returning = "ret")
	public void doAfterReturning(Object ret) throws Throwable{
		
	}
	
	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		//获取当前请求对象
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//记录请求信息
		WebLog webLog = new WebLog();
		Object result = joinPoint.proceed();
		
		
		return null;
	}
	
	/**
	 * 根据方法和传入的参数获取请求参数
	 * @param method
	 * @param args
	 * @return
	 */
	private Object getParameter(Method method, Object[] args) {
		List<Object> argsList = new ArrayList<>();
		Parameter[] parameters = method.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			//将RequestBody注解修饰的参数作为请求参数
			RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
			if (requestBody != null) {
				argsList.add(requestBody);
			}
		}
		
		
		
		
		return null;
	}
}
