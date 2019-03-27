package com.jeecg.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.author.LoginUser;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.springframework.stereotype.Service;

import com.jeecg.system.dao.JpSystemAuthDao;
import com.jeecg.system.entity.JpSystemAuthEntity;
import com.jeecg.system.service.JpSystemAuthService;
import com.jeecg.system.util.MenuUtil;

/**
 * 描述：菜单管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 16时30分27秒 星期五 
 * @version:1.0
 */
@Service("jpSystemAuthService")
public class JpSystemAuthServiceImpl implements JpSystemAuthService {
	@Resource
	private JpSystemAuthDao jpSystemAuthDao;

	@Override
	public JpSystemAuthEntity get(String id) {
		return jpSystemAuthDao.get(id);
	}

	@Override
	public int update(JpSystemAuthEntity jpSystemAuth) {
		return jpSystemAuthDao.update(jpSystemAuth);
	}

	@Override
	public void insert(JpSystemAuthEntity jpSystemAuth) {
		String pid= jpSystemAuth.getParentId();
		String pdeep="";
		if(oConvertUtils.isNotEmpty(pid)){
			//不是根节点
			Integer parentDeep=jpSystemAuthDao.getParentDeep(pid);
			if(null != parentDeep){
				pdeep = String.valueOf(parentDeep);
			}
			//String parentDeep=String.valueOf();
		}else{
			pid="0";//设置默认值
			jpSystemAuth.setParentId(pid);
		}
		Integer sort=jpSystemAuth.getSortNo();
		if(sort==null){
			Integer maxSort = jpSystemAuthDao.getMaxSort(pid);
			if(maxSort == null){
				sort=1;
				jpSystemAuth.setSortNo(1);
			}else{
				sort=maxSort+1;
				jpSystemAuth.setSortNo(1+maxSort);
			}
		}
		jpSystemAuth.setDeep(pdeep+sort);
		
		jpSystemAuthDao.insert(jpSystemAuth);
		
	}

	@Override
	public MiniDaoPage<JpSystemAuthEntity> getAll(JpSystemAuthEntity jpSystemAuth, int page, int rows) {
		return jpSystemAuthDao.getAll(jpSystemAuth, page, rows);
	}

	@Override
	public void delete(JpSystemAuthEntity jpSystemAuth) {
		jpSystemAuthDao.delete(jpSystemAuth);
		//删除关联关系
		jpSystemAuthDao.deleteAuthRel(jpSystemAuth.getId());
	}

	@Override
	public MiniDaoPage<JpSystemAuthEntity> getDeepAll(JpSystemAuthEntity jpSystemAuth, int page, int rows) {
		return jpSystemAuthDao.getDeepAll(jpSystemAuth, page, rows);
	}

	@Override
	public List<Map<String, String>> getMenuTree() {
		return jpSystemAuthDao.getMenuTree();
	}

	@Override
	public boolean hasSubNode(String id) {
		Integer count = jpSystemAuthDao.getSubNodeCount(id);
		if(count==null||count==0){
			return false;
		}
		return true;
	}

	@Override
	public List<JpSystemAuthEntity> getAll() {
		return jpSystemAuthDao.getAll();
	}

	@Override
	public boolean checkLoginUserAuth(String user_id, String url) {
		Integer a = jpSystemAuthDao.getCountAuthByUser(user_id, url);
		return (a!=null && a >0);
	}

	@Override
	public String initMenu() {
		LoginUser user = (LoginUser)ContextHolderUtils.getRequest().getSession().getAttribute(ContextHolderUtils.LOCAL_CLINET_USER);
				//ContextHolderUtils.getLoginSessionUser();
		//测试数据
		//user = new LoginUser();
		//user.setId("yonhu");
		List<JpSystemAuthEntity> list = jpSystemAuthDao.getAuthsByUser(user.getId());
		String menuHtml = MenuUtil.combineHtml(list, "0", 1);
		return menuHtml;
	}
	
}
