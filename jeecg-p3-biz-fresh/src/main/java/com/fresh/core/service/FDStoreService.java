package com.fresh.core.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.fresh.core.entity.FDStoreEntity;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 16时13分38秒 星期三 
 * @version:1.0
 */
public interface FDStoreService {
	public FDStoreEntity get(String id);

	public int update(FDStoreEntity fDStore);

	public void insert(FDStoreEntity fDStore);

	public MiniDaoPage<FDStoreEntity> getAll(FDStoreEntity fDStore,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
