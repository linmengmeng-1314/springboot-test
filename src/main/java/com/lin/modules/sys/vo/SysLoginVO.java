package com.lin.modules.sys.vo;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.lin.common.baseenum.BaseEnum.ReturnMsgEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2019-05-20 13:12:11
 */
@ApiModel("登录参数")
public class SysLoginVO {
	@ApiModelProperty(value="密码",example="123456")
	@ApiParam(value="密码",defaultValue="123456")
	private String password;
	
	@Size(min=0,max=11,message="手机号格式不正确")
	@ApiModelProperty(value="手机号",example="18513213961")
	@ApiParam(value="手机号",defaultValue="18513213961")
	@NotNull(message = "请输入手机号")
	private String mobile;
	
	@ApiModelProperty(value="短信验证码",example="654321")
	@ApiParam(value="短信验证码",defaultValue="654321")
	private String messageCode;
	
	/**
	 * 0：密码登录
	 * 1：短信验证码登录
	 */
	@ApiModelProperty(value="登录方式",example="填写例子")
	@ApiParam(value="登录方式",defaultValue="填写例子")
	@NotNull(message = "请选择登陆方式")
	@Range(min = 0,max = 1,message = "请选择正确登陆方式")
	private Integer loginType;
	
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}



	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("com.csi.modules.sys.vo.SysLoginVOEnum ={")
		.append("password=").append(password)
		.append(",mobile=").append(getMobile())
		.append(",messageCode=").append(messageCode)
		.append("}");
		return builder.toString();
	}
	
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public int getLoginType() {
		return loginType;
	}

	public enum LoginType{
		MESSAGE_LOGIN(1),
		PASSWORD_LOGIN(0);
		private int loginType;
		LoginType(int loginType){
			this.loginType = loginType;
		}
		public int getLoginType() {
			return loginType;
		}
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public static enum SysLoginVOEnum{
		password("password","密码"),
		email("email","邮箱"),
		mobile("mobile","手机号"),
		company_name("companyName","公司名称"),
		business_license_number("businessLicenseNumber","营业执照号");
		private String fieldName;
		private String remark;
		SysLoginVOEnum(String fieldName,String remark){
			this.fieldName = fieldName;
			this.remark = remark;
		}
		
		public String get(){
			return this.fieldName;
		}
		
		public String getRemark(){
			return this.remark;
		}
	}
	
	@ApiModel("返回执行结果")
	public static class SysLoginVOSResultVO {
		private static SysLoginVOSResultVO fail = new SysLoginVOSResultVO(ReturnMsgEnum.FAIL.getCode(),ReturnMsgEnum.FAIL.getMsg());

		private static SysLoginVOSResultVO success= new SysLoginVOSResultVO(ReturnMsgEnum.SUCCESS.getCode(),ReturnMsgEnum.SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private String code;
		
		@ApiModelProperty(value="返回执行结果信息")
		private String msg;
		
		@ApiModelProperty(value="返回token")
		private String token;
		
		public SysLoginVOSResultVO(String code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.SysLoginVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public SysLoginVOSResultVO(){
		}
		
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		public static SysLoginVOSResultVO ok() {
			return success;
		}
	
		public static SysLoginVOSResultVO  fail() {
			return fail;
		}
		
		public String getMsg() {
			return msg;
		}
	
		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}
}
