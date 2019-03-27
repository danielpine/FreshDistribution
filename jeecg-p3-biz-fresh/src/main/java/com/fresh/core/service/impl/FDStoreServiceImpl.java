package com.fresh.core.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.fresh.core.dao.FDStoreDao;
import com.fresh.core.entity.FDStoreEntity;
import com.fresh.core.service.FDStoreService;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 16时13分38秒 星期三 
 * @version:1.0
 */

@Service("fDStoreService")
public class FDStoreServiceImpl implements FDStoreService {
	@Resource
	private FDStoreDao fDStoreDao;

	@Override
	public FDStoreEntity get(String id) {
		return fDStoreDao.get(id);
	}

	@Override
	public int update(FDStoreEntity fDStore) {
		return fDStoreDao.update(fDStore);
	}

	@Override
	public void insert(FDStoreEntity fDStore) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		fDStore.setId(randomSeed);
		fDStoreDao.insert(fDStore);
		
	}

	@Override
	public MiniDaoPage<FDStoreEntity> getAll(FDStoreEntity fDStore, int page, int rows) {
		return fDStoreDao.getAll(fDStore, page, rows);
	}

	@Override
	public void delete(String id) {
		fDStoreDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			fDStoreDao.deleteById(id);
		}
	}
}
