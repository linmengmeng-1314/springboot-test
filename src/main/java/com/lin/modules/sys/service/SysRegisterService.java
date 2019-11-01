package com.lin.modules.sys.service;

import com.lin.modules.sys.vo.SysRegisterVO;

/**
 * 用户Token
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface SysRegisterService {

	/**
	 * 发送注册验证码
	 * @param mobileNumber
	 */
	public boolean sendRegisterCode(String mobileNumber,int codeType);
	/**
	 * 发送登陆验证码
	 * @param mobileNumber
	 */
	public boolean sendLoginCode(String mobileNumber);
	/**
	 * 发送重置密码验证码
	 * @param mobileNumber
	 */
	public boolean sendResetCode(String mobileNumber);
	
	/**
	 * 注册
	 * @param sysRegisterVO
	 */
	public void register(SysRegisterVO sysRegisterVO);

}
