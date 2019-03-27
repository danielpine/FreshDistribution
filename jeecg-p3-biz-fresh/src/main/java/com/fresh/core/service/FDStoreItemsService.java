package com.fresh.core.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.fresh.core.entity.FDStoreItemsEntity;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 17时33分21秒 星期三 
 * @version:1.0
 */
public interface FDStoreItemsService {
	public FDStoreItemsEntity get(String id);

	public int update(FDStoreItemsEntity fDStoreItems);

	public void insert(FDStoreItemsEntity fDStoreItems);

	public MiniDaoPage<FDStoreItemsEntity> getAll(FDStoreItemsEntity fDStoreItems,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
