package com.lin.modules.sys.basenum;

public enum ResultStateEnum {
	
	/**
	 * 1：短信验证码无效
	 */
	CODE_INVALID(801,"短信验证码无效"),
	
	/**
	 * 1：用户已存在
	 */
	USER_ALREADY(803,"用户已存在"),
	
	/**
	 * 1：短信验证码已发送
	 */
	CODE_SUCCESS(200,"短信验证码已发送"),
	
	/**
	 * 1：短信验证码核验成功
	 */
	CODE_CHECK_SUCCESS(200,"短信验证码核验成功"),
	
	/**
	 * 1：短信验证码发送失败
	 */
	CODE_FAIL(805,"短信验证码发送失败"),
	
	/**
	 * 1：最近3小时内，密码错误次数超过20，请稍后再试
	 */
	PASSWORD_ERROR_OUT_20(806,"最近3小时内，密码错误次数超过20，请稍后再试"),
	
	/**
	 * 1：帐号或密码错误
	 */
	PASSWORD_OR_ACCOUNT_ERROR(807,"帐号或密码错误"),
	
	/**
	 * 1：帐号或密码错误
	 */
	ACCOUNT_FREEZE(808,"账号已被锁定,请联系运维人员"),
	
	
	/**
	 * 1：用户已存在
	 */
	USER_NOT_EXIST(810,"该账号不存在"),
	
	/**
	 * 1：两次输入密码 不一致
	 */
	PASSWORD_TWICE_DIFFERENCE(809,"两次输入密码 不一致");
	
	private int code;
	private String msg;
	
	
	private ResultStateEnum(int code,String msg) {
		this.setCode(code);
		this.setMsg(msg);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
