package com.lin.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.lin.common.utils.R;
import com.lin.modules.sys.entity.SysUserEntity;
import com.lin.modules.sys.vo.SysEditEmailVO;
import com.lin.modules.sys.vo.SysEditPasswordVO;
import com.lin.modules.sys.vo.SysLoginVO;
import com.lin.modules.sys.vo.SysResetPasswordVO;


/**
 * 系统用户
 * 
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService {

	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);
	
	/**
	 * 根据用户ID，查询用户
	 * @param userId
	 * @return
	 */
	SysUserEntity queryObject(Long userId);
	
	/**
	 * 查询用户列表
	 */
	List<SysUserEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存用户
	 */
	void save(SysUserEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);
	
	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);
	
	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	int updatePassword(Long userId, String password, String newPassword);
	
	/**
	 * 登录
	 */
	R login(SysLoginVO sysLoginVO);

	/**
	 * 修改密码 
	 * @param sysEditPasswordVO
	 */
	void editPassword(SysEditPasswordVO sysEditPasswordVO);

	/**
	 * 修改邮箱
	 * @param sysEditEmailVO
	 */
	void editemail(SysEditEmailVO sysEditEmailVO);

	/**
	 * 重置密码
	 * @param sysResetPasswordVO
	 */
	void resetPassword(SysResetPasswordVO sysResetPasswordVO);
}
