package com.jeecg.system.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.system.entity.JpSystemUserEntity;

/**
 * 描述：用户管理
 * @author：www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
@Repository
public interface JpSystemUserDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM jp_system_user WHERE ID = :id")
	JpSystemUserEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param jpSystemUser
	 * @return
	 */
	int update(@Param("jpSystemUser") JpSystemUserEntity jpSystemUser);
	
	@Sql("update jp_system_user set del_flag = '1' where id = :id")
	void updateForDel(@Param("id") String id);
	
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("jpSystemUser") JpSystemUserEntity jpSystemUser);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param jpSystemUser
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(JpSystemUserEntity.class)
	public MiniDaoPage<JpSystemUserEntity> getAll(@Param("jpSystemUser") JpSystemUserEntity jpSystemUser,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from jp_system_user WHERE ID = :jpSystemUser.id")
	public void delete(@Param("jpSystemUser") JpSystemUserEntity jpSystemUser);
	
	/**用户-角色关系表插入数据*/
	@Sql("insert into jp_system_user_role_rel(role_id,user_id) values(:role_id,:user_id)")
	public void insertUserRole(@Param("role_id") String role_id,@Param("user_id") String user_id);
	
	/**用户-角色关系表删除数据*/
	@Sql("delete from jp_system_user_role_rel where user_id = :user_id")
	public void deleteUserRole(@Param("user_id") String user_id);
	
	@Sql("select * from jp_system_user where user_name = :name")
	public List<JpSystemUserEntity> getUserByName(@Param("name") String name);
}

