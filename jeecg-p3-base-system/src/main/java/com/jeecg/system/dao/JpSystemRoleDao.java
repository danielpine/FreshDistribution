package com.jeecg.system.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.system.entity.JpSystemRoleEntity;

/**
 * 描述：角色管理
 * @author：www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
@Repository
public interface JpSystemRoleDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_system_role WHERE ID = :id")
	JpSystemRoleEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpSystemRole
	 * @return
	 */
	int update(@Param("jpSystemRole") JpSystemRoleEntity jpSystemRole);
	
	/**
	 * 逻辑删除
	 * @param id
	 */
	@Sql("update jp_system_role set del_flag = '1' where id = :id")
	void updateForDel(@Param("id") String id);
	
	/**删除指定角色名下的所有菜单*/
	@Sql("delete from jp_system_role_auth_rel where role_id = :role_id")
	public void deleteAllMenuByRole(@Param("role_id") String role_id);
	/**
	 * 删除角色-用户的关联关系
	 */
	@Sql("delete from jp_system_user_role_rel where role_id = :role_id")
	void deleteRoleUserRel(@Param("role_id") String role_id);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpSystemRole") JpSystemRoleEntity jpSystemRole);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpSystemRole
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpSystemRoleEntity.class)
	public MiniDaoPage<JpSystemRoleEntity> getAll(@Param("jpSystemRole") JpSystemRoleEntity jpSystemRole,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_system_role WHERE ID = :jpSystemRole.id")
	public void delete(@Param("jpSystemRole") JpSystemRoleEntity jpSystemRole);
	
	/**查询所有未被删除的角色*/
	@Sql("SELECT * FROM jp_system_role WHERE del_flag = '0'")
	public List<JpSystemRoleEntity> queryAllRoles();
	
	/**查询所有未被删除的角色*/
	public List<JpSystemRoleEntity> queryAllRolesWithSelect(@Param("user_id") String user_id);
	
	/**根据角色id获取该角色下的菜单*/
	public List<Map<String, String>> getRoleMenu(@Param("role_id") String role_id);
	
	/**添加角色菜单权限*/
	@Sql("insert into jp_system_role_auth_rel (role_id,auth_id) values (:role_id,:auth_id)")
	public void addRoleMenu(@Param("role_id")String role_id,@Param("auth_id")String auth_id);
	
}

