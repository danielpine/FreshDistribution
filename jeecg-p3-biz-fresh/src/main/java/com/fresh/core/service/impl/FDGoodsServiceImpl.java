package com.fresh.core.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.fresh.core.dao.FDGoodsDao;
import com.fresh.core.entity.FDGoodsEntity;
import com.fresh.core.service.FDGoodsService;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 21时30分42秒 星期三 
 * @version:1.0
 */

@Service("fDGoodsService")
public class FDGoodsServiceImpl implements FDGoodsService {
	@Resource
	private FDGoodsDao fDGoodsDao;

	@Override
	public FDGoodsEntity get(String id) {
		return fDGoodsDao.get(id);
	}

	@Override
	public int update(FDGoodsEntity fDGoods) {
		return fDGoodsDao.update(fDGoods);
	}

	@Override
	public void insert(FDGoodsEntity fDGoods) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		fDGoods.setId(randomSeed);
		fDGoodsDao.insert(fDGoods);
		
	}

	@Override
	public MiniDaoPage<FDGoodsEntity> getAll(FDGoodsEntity fDGoods, int page, int rows) {
		return fDGoodsDao.getAll(fDGoods, page, rows);
	}

	@Override
	public void delete(String id) {
		fDGoodsDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			fDGoodsDao.deleteById(id);
		}
	}
}
