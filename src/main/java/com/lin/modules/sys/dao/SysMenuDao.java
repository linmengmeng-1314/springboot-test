package com.lin.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lin.mapper.base.BaseMappper;
import com.lin.modules.sys.entity.SysMenuEntity;

/**
 * 菜单管理
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2016年9月18日 上午9:33:01
 */
@Mapper
public interface SysMenuDao extends BaseMappper<SysMenuEntity,Long> {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList(Long userId);
}
