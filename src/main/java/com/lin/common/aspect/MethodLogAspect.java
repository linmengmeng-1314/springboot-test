package com.lin.common.aspect;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lin.common.annotation.MethodLog;
import com.lin.common.baseenum.LogTypeEnum;
import com.lin.config.StatsdAutoConfiguration.StatsdUtil;


/**
 * 
 * @ClassName: MethodLogAspect 
 * @Description: 记录方法日志，切面处理类 <br/> 1、记录方法入口唯一标识 <br/> 2、记录参数 <br/> 3、记录方法执行时间 <br/> 4、可发送graphics记录
 * @author honghuiwang 
 * @date 2017年9月2日 上午12:01:47 
 *
 */
@Aspect
@Component
public class MethodLogAspect{
	
	private Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required=false)
	private StatsdUtil statsdUtil;
	@Pointcut("@annotation(com.lin.common.annotation.MethodLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		Method method = ((MethodSignature) point.getSignature()).getMethod();
		MethodLog syslog = method.getAnnotation(MethodLog.class);
		String[] keys = syslog.keys();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
		int number = request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1;
		request.setAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue(),number);
		String str = point.getTarget().getClass().getName()+"."+method.getName();
		for (int i = 0; i < keys.length; i++) {
			if(StringUtils.isEmpty(request.getParameter(keys[i]))) {
				continue;
			}
			str+="."+request.getParameter(keys[i]);
		}
		Object result = null;
		//记录请求前日志
		intiMethodLog(point,number);
		try {
			result = point.proceed();
			//执行时长(毫秒)
			long time = System.currentTimeMillis() - beginTime;
			if(statsdUtil!=null) {
				statsdUtil.sendAgent(str,(int) time);
			}
		}catch (Exception e) {
			long time = System.currentTimeMillis() - beginTime;
			if(statsdUtil!=null) {
				statsdUtil.sendAgent(str,(int) time);
			}
			throw e;
		}
		finally {
			long time = System.currentTimeMillis() - beginTime;
			//记录执行后返回日志
			resultMethodLog(point, result,time,number);
			
		}
		
		return result;
	}
	private void resultMethodLog(ProceedingJoinPoint joinPoint,Object result,long time,int number){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
		request.setAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue(),request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1);
		log.info("请求唯一标识->{}-{} 返回结果->{} 方法执行时间->{}",request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()),number,result, time);
	}
	
	private void intiMethodLog(ProceedingJoinPoint joinPoint, int number){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		MethodLog methodLog = method.getAnnotation(MethodLog.class);
		String methodInfo = methodLog.value();
		Object[] args = joinPoint.getArgs();
		//获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();		
	    request.setAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue(),request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue())!=null?request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()).toString():UUID.randomUUID().toString().replaceAll("-", ""));
		log.info("请求唯一标识->{}-{} 方法描述->{} 请求参数->{} 方法位置->{}",request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()),number,methodInfo, args,joinPoint);
	}
}
