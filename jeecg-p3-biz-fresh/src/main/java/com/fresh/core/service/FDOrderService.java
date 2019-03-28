package com.fresh.core.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.fresh.core.entity.FDOrderEntity;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2019年03月28日 18时39分50秒 星期四 
 * @version:1.0
 */
public interface FDOrderService {
	public FDOrderEntity get(String id);

	public int update(FDOrderEntity fDOrder);

	public void insert(FDOrderEntity fDOrder);

	public MiniDaoPage<FDOrderEntity> getAll(FDOrderEntity fDOrder,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
