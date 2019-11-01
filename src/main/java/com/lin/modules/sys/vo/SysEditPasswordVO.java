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
@ApiModel("修改密码参数")
public class SysEditPasswordVO {
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="旧密码",example="123456")
	@ApiParam(value="旧密码",defaultValue="123456")
	@NotNull(message = "旧密码不能为空")
	private String oldPassword;
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="新密码1",example="1234567")
	@ApiParam(value="新密码1",defaultValue="1234567")
	@NotNull(message = "新密码不能为空")
	private String password1;
	
	@Size(min=6,max=32,message="密码长度为6-32个字符")
	@ApiModelProperty(value="新密码2",example="1234567")
	@ApiParam(value="新密码2",defaultValue="1234567")
	@NotNull(message = "新密码不能为空")
	private String password2;

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("com.csi.modules.sys.vo.SysEditPasswordVOEnum ={")
		.append("oldPassword=").append(getOldPassword())
		.append(",password1=").append(getPassword1())
		.append(",password2=").append(getPassword2())
		.append("}");
		return builder.toString();
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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
	
	@ApiModel("返回执行结果")
	public static class SysEditPasswordVOSResultVO {
		private static SysEditPasswordVOSResultVO fail = new SysEditPasswordVOSResultVO(ReturnMsgEnum.FAIL.getCode(),ReturnMsgEnum.FAIL.getMsg());

		private static SysEditPasswordVOSResultVO success= new SysEditPasswordVOSResultVO(ReturnMsgEnum.SUCCESS.getCode(),ReturnMsgEnum.SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private String code;
		
		@ApiModelProperty(value="返回执行结果信息")
		private String msg;
		
		public SysEditPasswordVOSResultVO(String code,String msg){
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
		public SysEditPasswordVOSResultVO(){
		}
		
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		public static SysEditPasswordVOSResultVO ok() {
			return success;
		}
	
		public static SysEditPasswordVOSResultVO  fail() {
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
