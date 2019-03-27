package com.jeecg.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.springframework.stereotype.Service;

import com.jeecg.system.dao.JpSystemRoleDao;
import com.jeecg.system.entity.JpSystemRoleEntity;
import com.jeecg.system.service.JpSystemRoleService;

/**
 * 描述：角色管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */

@Service("jpSystemRoleService")
public class JpSystemRoleServiceImpl implements JpSystemRoleService {
	@Resource
	private JpSystemRoleDao jpSystemRoleDao;

	@Override
	public JpSystemRoleEntity get(String id) {
		return jpSystemRoleDao.get(id);
	}

	@Override
	public int update(JpSystemRoleEntity jpSystemRole) {
		return jpSystemRoleDao.update(jpSystemRole);
	}

	@Override
	public void insert(JpSystemRoleEntity jpSystemRole) {
		jpSystemRoleDao.insert(jpSystemRole);
	}

	@Override
	public MiniDaoPage<JpSystemRoleEntity> getAll(JpSystemRoleEntity jpSystemRole, int page, int rows) {
		return jpSystemRoleDao.getAll(jpSystemRole, page, rows);
	}

	@Override
	public void delete(JpSystemRoleEntity jpSystemRole) {
		jpSystemRoleDao.delete(jpSystemRole);
		//删除关联关系
		String role_id = jpSystemRole.getId();
		jpSystemRoleDao.deleteAllMenuByRole(role_id);
		jpSystemRoleDao.deleteRoleUserRel(role_id);
	}

	@Override
	public List<JpSystemRoleEntity> queryAllRoles() {
		return jpSystemRoleDao.queryAllRoles();
	}

	@Override
	public List<Map<String, String>> getRoleMenu(String role_id) {
		return jpSystemRoleDao.getRoleMenu(role_id);
	}

	@Override
	public void updateRoleMenu(String role_id, String[] menuIds) {
		//先删除后添加
		jpSystemRoleDao.deleteAllMenuByRole(role_id);
		for (String auth_id : menuIds) {
			if(oConvertUtils.isNotEmpty(auth_id)){
				jpSystemRoleDao.addRoleMenu(role_id, auth_id);
			}
		}
	}

	@Override
	public List<JpSystemRoleEntity> queryAllRoleWithSelect(String user_id) {
		return jpSystemRoleDao.queryAllRolesWithSelect(user_id);
	}
}
