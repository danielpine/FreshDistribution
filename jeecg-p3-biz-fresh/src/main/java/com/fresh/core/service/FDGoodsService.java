package com.fresh.core.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.fresh.core.entity.FDGoodsEntity;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 16时13分37秒 星期三 
 * @version:1.0
 */
public interface FDGoodsService {
	public FDGoodsEntity get(String id);

	public int update(FDGoodsEntity fDGoods);

	public void insert(FDGoodsEntity fDGoods);

	public MiniDaoPage<FDGoodsEntity> getAll(FDGoodsEntity fDGoods,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
