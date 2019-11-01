package com.lin.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lin.common.aspect.ContextLog;
import com.lin.common.utils.R;

/**
 * 
 * @ClassName: RRExceptionHandler 
 * @Description: ExceptionHandlerExceptionResolver
 * @author honghuiwang 
 * @date 2017年9月2日 下午8:15:18 
 *
 */
@RestControllerAdvice
public class BaseExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(CheckException.class)
	public R handleCheckException(CheckException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		ContextLog.error(r.toString(), e);
		return r;
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		R r = new R();
		r.put("code", "500");
		r.put("msg", "系统繁忙,请稍后再试");
		ContextLog.error(r.toString(), e);
		return r;
	}
	@ExceptionHandler(BusinessException.class)
	public R handleBusinessException(BusinessException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		ContextLog.error(r.toString(), e);
		return r;
	}
}

