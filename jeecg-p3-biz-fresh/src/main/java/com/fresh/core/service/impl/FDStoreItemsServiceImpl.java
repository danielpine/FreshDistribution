package com.fresh.core.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.fresh.core.dao.FDStoreItemsDao;
import com.fresh.core.entity.FDStoreItemsEntity;
import com.fresh.core.service.FDStoreItemsService;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 17时33分21秒 星期三 
 * @version:1.0
 */

@Service("fDStoreItemsService")
public class FDStoreItemsServiceImpl implements FDStoreItemsService {
	@Resource
	private FDStoreItemsDao fDStoreItemsDao;

	@Override
	public FDStoreItemsEntity get(String id) {
		return fDStoreItemsDao.get(id);
	}

	@Override
	public int update(FDStoreItemsEntity fDStoreItems) {
		return fDStoreItemsDao.update(fDStoreItems);
	}

	@Override
	public void insert(FDStoreItemsEntity fDStoreItems) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		fDStoreItems.setId(randomSeed);
		fDStoreItemsDao.insert(fDStoreItems);
		
	}

	@Override
	public MiniDaoPage<FDStoreItemsEntity> getAll(FDStoreItemsEntity fDStoreItems, int page, int rows) {
		return fDStoreItemsDao.getAll(fDStoreItems, page, rows);
	}

	@Override
	public void delete(String id) {
		fDStoreItemsDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			fDStoreItemsDao.deleteById(id);
		}
	}
}
