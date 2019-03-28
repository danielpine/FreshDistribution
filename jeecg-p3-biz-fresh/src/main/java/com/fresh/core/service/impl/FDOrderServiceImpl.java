package com.fresh.core.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.fresh.core.dao.FDOrderDao;
import com.fresh.core.entity.FDOrderEntity;
import com.fresh.core.service.FDOrderService;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2019年03月28日 18时39分50秒 星期四 
 * @version:1.0
 */

@Service("fDOrderService")
public class FDOrderServiceImpl implements FDOrderService {
	@Resource
	private FDOrderDao fDOrderDao;

	@Override
	public FDOrderEntity get(String id) {
		return fDOrderDao.get(id);
	}

	@Override
	public int update(FDOrderEntity fDOrder) {
		return fDOrderDao.update(fDOrder);
	}

	@Override
	public void insert(FDOrderEntity fDOrder) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		fDOrder.setId(randomSeed);
		fDOrderDao.insert(fDOrder);
		
	}

	@Override
	public MiniDaoPage<FDOrderEntity> getAll(FDOrderEntity fDOrder, int page, int rows) {
		return fDOrderDao.getAll(fDOrder, page, rows);
	}

	@Override
	public void delete(String id) {
		fDOrderDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			fDOrderDao.deleteById(id);
		}
	}
}
