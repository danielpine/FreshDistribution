package com.fresh.core.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.fresh.core.entity.FDOrderEntity;

/**
 * 描述：订单表
 * @author：www.jeecg.org
 * @since：2019年03月28日 18时39分50秒 星期四 
 * @version:1.0
 */
@Repository
public interface FDOrderDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM f_d_order WHERE ID = :id")
	FDOrderEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param fDOrder
	 * @return
	 */
	int update(@Param("fDOrder") FDOrderEntity fDOrder);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("fDOrder") FDOrderEntity fDOrder);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param fDOrder
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(FDOrderEntity.class)
	public MiniDaoPage<FDOrderEntity> getAll(@Param("fDOrder") FDOrderEntity fDOrder,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from f_d_order WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from f_d_order WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

