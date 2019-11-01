package com.lin.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lin.mapper.base.BaseMappper;
import com.lin.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogDao extends BaseMappper<SysLogEntity,Long> {
	
}
