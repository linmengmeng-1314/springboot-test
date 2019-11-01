package com.lin.common.aspect;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lin.common.annotation.SimpleLog;
import com.lin.common.baseenum.LogTypeEnum;


/**
 * 
 * @ClassName: SimpleLogAspect 
 * @Description: 记录基本日志，切面处理类 <br/> 1、记录方法入口唯一标识 <br/> 2、记录参数 
 * @author honghuiwang 
 * @date 2017年9月2日 上午12:01:47 
 *
 */
@Aspect
@Component
@Order(-1)
public class SimpleLogAspect{
	private Logger log = LogManager.getLogger(this.getClass());
	
	@Pointcut("@annotation(com.lin.common.annotation.SimpleLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
		int number = request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1;
		request.setAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue(),number);
		//记录请求前日志
		intiSimpleLog(point,number);
		//执行方法
		Object result = point.proceed();
		//记录执行后返回日志
		resultSimpleLog(point, result,System.currentTimeMillis()-beginTime,number);

		return result;
	}
	private void resultSimpleLog(ProceedingJoinPoint joinPoint,Object result,long time,int number){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
		log.info("请求唯一标识->{}-{} 返回结果->{} 方法执行时间->{}",request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()),number,result, time);
	}
	
	private void intiSimpleLog(ProceedingJoinPoint joinPoint,int number){

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SimpleLog simpleLog = method.getAnnotation(SimpleLog.class);
		String simpleInfo = simpleLog.value();
		Object[] args = joinPoint.getArgs();
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
	    request.setAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue(),request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue())!=null?request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()).toString():UUID.randomUUID().toString().replaceAll("-", ""));
		log.info("请求唯一标识->{}-{} 方法描述->{} 请求参数->{} 方法位置->{}",request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()),number,simpleInfo, args,joinPoint);
	}
	
}
