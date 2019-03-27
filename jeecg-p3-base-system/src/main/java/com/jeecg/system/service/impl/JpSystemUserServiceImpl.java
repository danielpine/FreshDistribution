package com.jeecg.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.springframework.stereotype.Service;

import com.jeecg.system.dao.JpSystemUserDao;
import com.jeecg.system.entity.JpSystemUserEntity;
import com.jeecg.system.service.JpSystemUserService;
import com.jeecg.system.util.PasswordUtil;

/**
 * 描述：用户管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */

@Service("jpSystemUserService")
public class JpSystemUserServiceImpl implements JpSystemUserService {
	@Resource
	private JpSystemUserDao jpSystemUserDao;

	@Override
	public JpSystemUserEntity get(String id) {
		return jpSystemUserDao.get(id);
	}

	@Override
	public int update(JpSystemUserEntity jpSystemUser) {
		return jpSystemUserDao.update(jpSystemUser);
	}

	@Override
	public void insert(JpSystemUserEntity jpSystemUser) {
		jpSystemUserDao.insert(jpSystemUser);
		
	}

	@Override
	public MiniDaoPage<JpSystemUserEntity> getAll(JpSystemUserEntity jpSystemUser, int page, int rows) {
		return jpSystemUserDao.getAll(jpSystemUser, page, rows);
	}

	@Override
	public void delete(JpSystemUserEntity jpSystemUser) {
		jpSystemUserDao.delete(jpSystemUser);
		//删除关联关系
		jpSystemUserDao.deleteUserRole(jpSystemUser.getId());
	}

	@Override
	public void addUserAndRole(JpSystemUserEntity jpSystemUser, String[] roleIds) {
		jpSystemUserDao.insert(jpSystemUser);
		if(roleIds != null && roleIds.length>0){
			for(String roleId:roleIds){
				if(oConvertUtils.isNotEmpty(roleId)){
					jpSystemUserDao.insertUserRole(roleId, jpSystemUser.getId());
				}
			}
		}
		
	}

	@Override
	public void updateUserAndRole(JpSystemUserEntity jpSystemUser, String[] roleIds) {
		jpSystemUserDao.update(jpSystemUser);
		if(roleIds != null && roleIds.length>0){
			jpSystemUserDao.deleteUserRole(jpSystemUser.getId());
			for(String roleId:roleIds){
				if(oConvertUtils.isNotEmpty(roleId)){
					jpSystemUserDao.insertUserRole(roleId, jpSystemUser.getId());
				}
			}
		}
	}

	@Override
	public JpSystemUserEntity checkUser(String name, String password) {
		List<JpSystemUserEntity> users = jpSystemUserDao.getUserByName(name);
		if(users != null && users.size()>0){
			for (JpSystemUserEntity user : users) {
				String pw = user.getPassword();
				//update-begin-author:taoYan date：20170811 for:密码加密方法传参修改--
				String passwordDigest = PasswordUtil.encrypt(password,user.getUserName(),PasswordUtil.getStaticSalt());
				//update-end-author:taoYan date：20170811 for:密码加密方法传参修改--
				if(passwordDigest.equals(pw)){
					return user;
				}
			}
		}
		return null;
	}
}
