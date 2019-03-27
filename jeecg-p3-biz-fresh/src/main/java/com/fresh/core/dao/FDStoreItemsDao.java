package com.fresh.core.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.fresh.core.entity.FDStoreItemsEntity;

/**
 * 描述：商品表
 * @author：www.jeecg.org
 * @since：2019年03月27日 17时33分21秒 星期三 
 * @version:1.0
 */
@Repository
public interface FDStoreItemsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM f_d_store_items WHERE ID = :id")
	FDStoreItemsEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param fDStoreItems
	 * @return
	 */
	int update(@Param("fDStoreItems") FDStoreItemsEntity fDStoreItems);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("fDStoreItems") FDStoreItemsEntity fDStoreItems);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param fDStoreItems
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(FDStoreItemsEntity.class)
	public MiniDaoPage<FDStoreItemsEntity> getAll(@Param("fDStoreItems") FDStoreItemsEntity fDStoreItems,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from f_d_store_items WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from f_d_store_items WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

