package com.lin.modules.sys.vo;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@ApiModel("注册用户参数")
public class SysRegisterVO {

	@Max(4)
	@Min(0)
	@ApiModelProperty(value="短信类型",example="0")
	@ApiParam(value="短信类型",defaultValue="0")
	@NotNull(message = "短信类型不能为空")
	private int codeType;
	
	@Size(min=1,max=128,message="用户名长度必须为1-128个字符")
	@ApiModelProperty(value="用户名",example="王洪会")
	@ApiParam(value="用户名",defaultValue="王洪会")
	private String userName;
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="密码",example="123456")
	@ApiParam(value="密码",defaultValue="123456")
	private String password;
	
	@Size(min=6,max=64,message="邮箱长度为6-64个字符")
	@ApiModelProperty(value="邮箱",example="448697783@qq.com")
	@ApiParam(value="邮箱",defaultValue="448697783@qq.com")
	private String email;
	
	@Size(min=0,max=11,message="手机号格式不正确")
	@ApiModelProperty(value="手机号",example="18513213961")
	@ApiParam(value="手机号",defaultValue="18513213961")
	private String mobile;
	
	@Size(min=6,max=6,message="短信验证码长度必须为6个字符")
	@ApiModelProperty(value="短信验证码",example="654321")
	@ApiParam(value="短信验证码",defaultValue="654321")
	private String messageCode;
	
	@Max(4)
	@Min(0)
	@ApiModelProperty(value="用户类型",example="0")
	@ApiParam(value="用户类型",defaultValue="0")
	@NotNull(message = "用户类型不能为空")
	private int userType;
	
	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

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

	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}


	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("com.csi.modules.sys.vo.RegisterVO ={")
		.append("userName").append(userName)
		.append(",password=").append(password)
		.append(",email=").append(email)
		.append(",mobile=").append(mobile)
		.append(",messageCode=").append(messageCode)
		.append(",userType=").append(userType)
		.append("}");
		return builder.toString();
	}
	
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static enum RegisterVOEnum{
		password("password","密码"),
		email("email","邮箱"),
		mobile("mobile","手机号"),
		company_name("companyName","公司名称"),
		business_license_number("businessLicenseNumber","营业执照号");
		private String fieldName;
		private String remark;
		RegisterVOEnum(String fieldName,String remark){
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
	
	@ApiModel("返回注册结果")
	public static class RegisterVOSResultVO {
		private static RegisterVOSResultVO fail = new RegisterVOSResultVO(ReturnMsgEnum.FAIL.getCode(),ReturnMsgEnum.FAIL.getMsg());

		private static RegisterVOSResultVO success= new RegisterVOSResultVO(ReturnMsgEnum.SUCCESS.getCode(),ReturnMsgEnum.SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private String code;
		@ApiModelProperty(value="返回注册结果信息")
		private String msg;
		
		public RegisterVOSResultVO(String code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.RegisterVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public RegisterVOSResultVO(){
		}
		
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		public static RegisterVOSResultVO ok() {
			return success;
		}
	
		public static RegisterVOSResultVO  fail() {
			return fail;
		}
		
		public String getMsg() {
			return msg;
		}
	
		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
}
