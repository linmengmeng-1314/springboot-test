package com.lin.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lin.mapper.base.BaseMappper;
import com.lin.modules.sys.entity.SysConfigEntity;

/**
 * 系统配置信息
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2016年12月4日 下午6:46:16
 */
@Mapper
public interface SysConfigDao extends BaseMappper<SysConfigEntity,Long> {
	
	/**
	 * 根据key，查询value
	 */
	String queryByKey(String paramKey);
	
	/**
	 * 根据key，更新value
	 */
	int updateValueByKey(@Param("key") String key, @Param("value") String value);
	
}
