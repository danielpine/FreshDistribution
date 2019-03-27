package com.jeecg.system.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.system.entity.JpSystemRoleEntity;

/**
 * 描述：角色管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
public interface JpSystemRoleService {
	public JpSystemRoleEntity get(String id);

	public int update(JpSystemRoleEntity jpSystemRole);

	public void insert(JpSystemRoleEntity jpSystemRole);

	public MiniDaoPage<JpSystemRoleEntity> getAll(JpSystemRoleEntity jpSystemRole,int page,int rows);

	public void delete(JpSystemRoleEntity jpSystemRole);
	
	/**查询所有角色*/
	public List<JpSystemRoleEntity> queryAllRoles();
	/**查询所有角色并关联用户关系查看是否被选中*/
	public List<JpSystemRoleEntity> queryAllRoleWithSelect(String user_id);
	/**获取指定角色的菜单*/
	public List<Map<String, String>> getRoleMenu(String role_id);
	/**根据角色id和菜单id更新关系表*/
	public void updateRoleMenu(String role_id,String[] menuIds);
	
}
