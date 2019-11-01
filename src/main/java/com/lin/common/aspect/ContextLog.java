package com.lin.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lin.common.baseenum.LogTypeEnum;
import com.lin.common.utils.HttpContextUtils;


/**
 * 
 * @ClassName: SimpleLogAspect 
 * @Description: 记录基本日志，切面处理类 <br/> 1、记录方法入口唯一标识 <br/> 2、记录参数 
 * @author honghuiwang 
 * @date 2017年9月2日 上午12:01:47 
 *
 */
public class ContextLog{
	
	private static Logger log = LogManager.getLogger();

	/**
	 * 
	 * @param methodInfo 描述方法信息
	 * @param args[]     参数信息
	 * @param methName   方法名
	 * @param class      
	 */
	public static void debug(String methodInfo,Object args,String methName,Class<?> c){
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		int number = request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1;
		request.setAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue(),number);
		log.info("请求唯一标识->{}-{} 方法描述->{} 请求参数->{} 方法位置->{}.{}",request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue()),number,methodInfo, args,c.getName(),methName);
	}

	/**
	 * 
	 * @param methodInfo
	 * @param args
	 * @param methName
	 * @param c
	 * @param isWeb
	 */
	public static void info(String methodInfo,Object args,String methName,Class<?> c,boolean isWeb){
		HttpServletRequest request = null;
		int number = 0;
		String key  = "";
		if(isWeb) {
			 request = HttpContextUtils.getHttpServletRequest();
			 number = request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1;
			 key = (String) request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue());
		}
		log.info("请求唯一标识->{}-{} 方法描述->{} 请求参数->{} 方法位置->{}.{}",key,number,methodInfo, args,c.getName(),methName);
	}
	
	/**
	 * 
	 * @param methodInfo
	 * @param args
	 * @param methName
	 * @param c
	 * @param isWeb
	 */
	public static void info(String methodInfo,Object args,String methName,Class<?> c){
		info(methodInfo, args, methName, c, true);
	}
	
	/**
	 * @param errorMessage 异常描述
	 * @param e
	 */
	public static void error(String errorMessage,Exception e,boolean isWeb){
		HttpServletRequest request = null;
		int number = 0;
		String key  = "";

		if(isWeb) {
			request = HttpContextUtils.getHttpServletRequest();
			number = request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue())!=null?Integer.valueOf(request.getAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue()).toString())+1:1;
			request.setAttribute(LogTypeEnum.WHICH_NUMBER_KEY.getValue(),number);
			key = (String) request.getAttribute(LogTypeEnum.WHICH_MARK_KEY.getValue());
		}
		log.error("请求唯一标识->{}-{} 异常描述->{} ",key,number,errorMessage, e);
	}
	
	
	/**
	 * @param errorMessage 异常描述
	 * @param e
	 */
	public static void error(String errorMessage,Exception e){
		error(errorMessage, e,true);
	}
}
