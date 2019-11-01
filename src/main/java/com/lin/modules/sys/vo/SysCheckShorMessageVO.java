package com.lin.modules.sys.vo;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lin.modules.sys.basenum.ResultStateEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2019-05-20 13:12:11
 */
@ApiModel("核验验证码参数")
public class SysCheckShorMessageVO {
	
	@Max(4)
	@Min(0)
	@ApiModelProperty(value="短信类型",example="0")
	@ApiParam(value="短信类型",defaultValue="0")
	@NotNull(message = "短信类型不能为空")
	private int codeType;
	
	@Size(min=11,max=11,message="手机号长度为必须为11个字符")
	@ApiModelProperty(value="手机号",example="18513213961")
	@ApiParam(value="手机号",defaultValue="18513213961")
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	@Size(min=6,max=6,message="短信验证码长度必须为6个字符")
	@ApiModelProperty(value="短信验证码",example="654321")
	@ApiParam(value="短信验证码",defaultValue="654321")
	@NotNull(message = "短信验证码不能为空")
	private String messageCode;
	
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
		builder.append("com.csi.modules.sys.vo.SysCheckShorMessageVO ={")
		.append(",messageCode=").append(messageCode)
		.append(",mobile=").append(mobile)
		.append(",codeType=").append(codeType)
		.append("}");
		return builder.toString();
	}
	
	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	@ApiModel("返回执行结果")
	public static class SysCheckShorMessageVOSResultVO {

		private static SysCheckShorMessageVOSResultVO success= new SysCheckShorMessageVOSResultVO(ResultStateEnum.CODE_CHECK_SUCCESS.getCode(),ResultStateEnum.CODE_CHECK_SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",allowableValues="200:成功,其他表示失败")
		private int code;
		@ApiModelProperty(value="返回执行结果信息")
		private String msg;
		
		public SysCheckShorMessageVOSResultVO(int code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.SysCheckShorMessageVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public SysCheckShorMessageVOSResultVO(){
		}
		
		public int getCode() {
			return code;
		}
	
		public void setCode(int code) {
			this.code = code;
		}
		public static SysCheckShorMessageVOSResultVO ok() {
			return success;
		}
	
		public String getMsg() {
			return msg;
		}
	
		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
}
