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
@ApiModel("修改邮箱参数")
public class SysEditEmailVO {
	@Size(min=6,max=6,message="短信验证码长度必须为6个字符")
	@ApiModelProperty(value="短信验证码",example="654321")
	@ApiParam(value="短信验证码",defaultValue="654321")
	@NotNull(message = "短信验证码不能为空")
	private String messageCode;
	
	@Size(min=6,max=64,message="邮箱长度为6-64个字符")
	@ApiModelProperty(value="邮箱",example="448697783@qq.com")
	@ApiParam(value="邮箱",defaultValue="448697783@qq.com")
	@NotNull(message = "邮箱不能为空")
	private String email;
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("com.csi.modules.sys.vo.SysEditEmailVOEnum ={")
		.append("messageCode=").append(messageCode)
		.append(",email=").append(email)
		.append("}");
		return builder.toString();
	}
	
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ApiModel("返回执行结果")
	public static class SysEditEmailVOSResultVO {
		private static SysEditEmailVOSResultVO fail = new SysEditEmailVOSResultVO(ReturnMsgEnum.FAIL.getCode(),ReturnMsgEnum.FAIL.getMsg());

		private static SysEditEmailVOSResultVO success= new SysEditEmailVOSResultVO(ReturnMsgEnum.SUCCESS.getCode(),ReturnMsgEnum.SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private String code;
		
		@ApiModelProperty(value="返回执行结果信息")
		private String msg;
		
		public SysEditEmailVOSResultVO(String code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.SysEditEmailVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public SysEditEmailVOSResultVO(){
		}
		
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}
		public static SysEditEmailVOSResultVO ok() {
			return success;
		}
	
		public static SysEditEmailVOSResultVO  fail() {
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
