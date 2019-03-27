package com.jeecg.system.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.system.entity.JpSystemUserEntity;

/**
 * 描述：用户管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
public interface JpSystemUserService {
	public JpSystemUserEntity get(String id);

	public int update(JpSystemUserEntity jpSystemUser);

	public void insert(JpSystemUserEntity jpSystemUser);

	public MiniDaoPage<JpSystemUserEntity> getAll(JpSystemUserEntity jpSystemUser,int page,int rows);

	public void delete(JpSystemUserEntity jpSystemUser);
	
	/**添加用户 、用户-角色关系记录*/
	public void addUserAndRole(JpSystemUserEntity jpSystemUser,String[] roleIds);
	/**修改用户 、用户-角色关系记录*/
	public void updateUserAndRole(JpSystemUserEntity jpSystemUser,String[] roleIds);
	
	/**验证用户是否存在 是则返回该用户实例否则返回null*/
	public JpSystemUserEntity checkUser(String name,String password); 
	
}
