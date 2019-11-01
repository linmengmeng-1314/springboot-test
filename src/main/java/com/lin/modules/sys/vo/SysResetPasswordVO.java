package com.lin.modules.sys.vo;
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
@ApiModel("重置密码参数")
public class SysResetPasswordVO {
	@Size(min=0,max=11,message="手机号格式不正确")
	@ApiModelProperty(value="手机号",example="18513213961")
	@ApiParam(value="手机号",defaultValue="18513213961")
	@NotNull(message = "请填写手机号码")
	private String mobile;
	
	
	@Size(min=6,max=6,message="短信验证码长度必须为6个字符")
	@ApiModelProperty(value="短信验证码",example="654321")
	@ApiParam(value="短信验证码",defaultValue="654321")
	@NotNull(message = "请填写短信验证码")
	private String messageCode;
	
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="新密码1",example="123456")
	@ApiParam(value="新密码1",defaultValue="123456")
	@NotNull(message = "请填写新密码")
	private String password1;
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="新密码2",example="123456")
	@ApiParam(value="新密码2",defaultValue="123456")
	@NotNull(message = "请填写再次填写新密码")
	private String password2;

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("com.csi.modules.sys.vo.SysEditPasswordVOEnum ={")
		.append(",password1=").append(getPassword1())
		.append(",password2=").append(getPassword2())
		.append("}");
		return builder.toString();
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ApiModel("返回执行结果")
	public static class SysResetPasswordSResultVO {
		private static SysResetPasswordSResultVO fail = new SysResetPasswordSResultVO(ReturnMsgEnum.FAIL.getCode(),ReturnMsgEnum.FAIL.getMsg());

		private static SysResetPasswordSResultVO success= new SysResetPasswordSResultVO(ReturnMsgEnum.SUCCESS.getCode(),ReturnMsgEnum.SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private String code;
		
		@ApiModelProperty(value="返回执行结果信息")
		private String msg;
		
		public SysResetPasswordSResultVO(String code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.SysEditPasswordVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public SysResetPasswordSResultVO(){
		}
		
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		public static SysResetPasswordSResultVO ok() {
			return success;
		}
	
		public static SysResetPasswordSResultVO  fail() {
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
