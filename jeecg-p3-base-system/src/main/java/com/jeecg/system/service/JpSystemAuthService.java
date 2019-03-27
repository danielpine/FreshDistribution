package com.jeecg.system.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.system.entity.JpSystemAuthEntity;

/**
 * 描述：菜单管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 16时30分27秒 星期五 
 * @version:1.0
 */
public interface JpSystemAuthService {
	public JpSystemAuthEntity get(String id);

	public int update(JpSystemAuthEntity jpSystemAuth);

	public void insert(JpSystemAuthEntity jpSystemAuth);

	public MiniDaoPage<JpSystemAuthEntity> getAll(JpSystemAuthEntity jpSystemAuth,int page,int rows);
	
	public MiniDaoPage<JpSystemAuthEntity> getDeepAll(JpSystemAuthEntity jpSystemAuth,int page,int rows);

	public void delete(JpSystemAuthEntity jpSystemAuth);
	
	public List<Map<String, String>> getMenuTree(); 
	public List<JpSystemAuthEntity> getAll();
	
	/**是否有子菜单*/
	public boolean hasSubNode(String id);
	
	/**判断是否有权限访问*/
	public boolean checkLoginUserAuth(String user_id,String url);
	
	/**首页菜单拼接*/
	public String initMenu();
	
	
	
}
