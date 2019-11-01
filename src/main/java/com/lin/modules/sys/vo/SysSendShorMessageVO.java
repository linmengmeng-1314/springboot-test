package com.lin.modules.sys.vo;
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
@ApiModel("发送验证码参数")
public class SysSendShorMessageVO {
	
	@ApiModelProperty(value="短信类型",example="0")
	@ApiParam(value="短信类型",defaultValue="0")
	@NotNull(message = "短信类型不能为空")
	private int codeType;
	
	@Size(min=11,max=11,message="手机号长度必须为11个字符")
	@ApiModelProperty(value="手机号",example="18513213961")
	@ApiParam(value="手机号",defaultValue="18513213961")
	@NotNull(message = "手机号不能为空")
	private String mobile;

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
		builder.append("com.csi.modules.sys.vo.SysSendShorMessageVO ={")
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

	@ApiModel("返回执行结果")
	public static class SysSendShorMessageVOSResultVO {
		private static SysSendShorMessageVOSResultVO fail = new SysSendShorMessageVOSResultVO(ResultStateEnum.CODE_FAIL.getCode(),ResultStateEnum.CODE_FAIL.getMsg());

		private static SysSendShorMessageVOSResultVO success= new SysSendShorMessageVOSResultVO(ResultStateEnum.CODE_SUCCESS.getCode(),ResultStateEnum.CODE_SUCCESS.getMsg());

		@ApiModelProperty(value="状态码",notes="200:成功,其他表示失败")
		private int code;
		@ApiModelProperty(value="返回执行结果信息",notes = "成功或失败")
		private String msg;
		
		public SysSendShorMessageVOSResultVO(int code,String msg){
			this.code = code;
			this.msg = msg;
		}
		
		@Override
		public String toString(){
			StringBuilder builder = new StringBuilder();
			builder.append("com.csi.modules.sys.vo.SysSendShorMessageVOSResultVO ={")
			.append("code=").append(code)
			.append(",msg=").append(msg)
			.append("}");
			return builder.toString();
		}
		public SysSendShorMessageVOSResultVO(){
		}
		
		public int getCode() {
			return code;
		}
	
		public void setCode(int code) {
			this.code = code;
		}
		public static SysSendShorMessageVOSResultVO ok() {
			return success;
		}
	
		public static SysSendShorMessageVOSResultVO  fail() {
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
