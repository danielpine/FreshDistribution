package com.jeecg.system.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.system.entity.JpSystemAuthEntity;

/**
 * 描述：菜单管理
 * @author：www.jeecg.org
 * @since：2017年08月04日 16时30分27秒 星期五 
 * @version:1.0
 */
@Repository
public interface JpSystemAuthDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_system_auth WHERE ID = :id")
	JpSystemAuthEntity get(@Param("id") String id);
	
	/**
	 * 获取菜单的深度
	 * @param id
	 * @return
	 */
	@Sql("SELECT deep FROM jp_system_auth WHERE ID = :id")
	Integer getParentDeep(@Param("id") String id);
	
	/**
	 * 获取菜单的最大排序值，新增时用于设置默认排序值为当前max+1
	 * @param id
	 * @return
	 */
	@Sql("SELECT max(sort_no) FROM jp_system_auth WHERE parent_id = :id")
	Integer getMaxSort(@Param("id") String id);
	
	/**
	 * 获取子节点数量
	 * @param id
	 * @return
	 */
	@Sql("SELECT count(1) FROM jp_system_auth WHERE parent_id = :id")
	Integer getSubNodeCount(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpSystemAuth
	 * @return
	 */
	int update(@Param("jpSystemAuth") JpSystemAuthEntity jpSystemAuth);
	
	/**
	 * 逻辑删除
	 * @param id
	 */
	@Sql("update jp_system_auth set del_flag = '1' where id = :id")
	void updateForDel(@Param("id") String id);
	
	/**
	 * 删除菜单的关联关系
	 */ 
	@Sql("delete from jp_system_role_auth_rel where auth_id = :auth_id")
	void deleteAuthRel(@Param("auth_id") String auth_id);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpSystemAuth") JpSystemAuthEntity jpSystemAuth);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpSystemAuth
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpSystemAuthEntity.class)
	public MiniDaoPage<JpSystemAuthEntity> getAll(@Param("jpSystemAuth") JpSystemAuthEntity jpSystemAuth,@Param("page")  int page,@Param("rows") int rows);
	
	/**
	 * 获取菜单
	 * @param jpSystemAuth
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpSystemAuthEntity.class)
	public MiniDaoPage<JpSystemAuthEntity> getDeepAll(@Param("jpSystemAuth") JpSystemAuthEntity jpSystemAuth,@Param("page")  int page,@Param("rows") int rows);
	
	/**
	 * 获取菜单树，新增/修改界面需要
	 * @return
	 */
	public List<Map<String, String>> getMenuTree();
	
	@Sql("DELETE from jp_system_auth WHERE ID = :jpSystemAuth.id")
	public void delete(@Param("jpSystemAuth") JpSystemAuthEntity jpSystemAuth);
	
	/**
	 * 查询所有未被删除的菜单
	 * @return
	 */
	@Sql("select * from jp_system_auth where del_flag = '0'")
	public List<JpSystemAuthEntity> getAll(); 
	/**根据请求url和用户id查询授权菜单数量*/
	public Integer getCountAuthByUser(@Param("user_id") String user_id,@Param("url") String url);
	/**根据用户id查询所有授权菜单*/
	public List<JpSystemAuthEntity> getAuthsByUser(@Param("user_id") String user_id);
}

