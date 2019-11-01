package com.lin.common.exception;

import com.lin.common.baseenum.BaseEnum.CheckExceptionEnum;

/**
 * 业务异常
 * @date: 2016年10月12日 上午10:40:11
 */
@SuppressWarnings("serial")
public class CheckException extends BaseException {
	

	public CheckException(int code,String msg){
		super(msg);
		this.code = code;
	}
	public CheckException(String msg){
		super(msg);
		this.code = CheckExceptionEnum.CHECK_EXCEPTION.getCode();
	}
	
	@Override
	public Throwable fillInStackTrace() {
		return null;
	}
	
	public int getCode() {
		return code;
	}

	@SuppressWarnings("rawtypes")
	public Class getClazz() {
		return clazz;
	}

	public String getClassName() {
		return className;
	}

}


