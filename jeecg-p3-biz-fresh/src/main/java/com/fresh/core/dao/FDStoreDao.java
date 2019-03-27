package com.fresh.core.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.fresh.core.entity.FDStoreEntity;

/**
 * 描述：商品表
 * @author：www.jeecg.org
 * @since：2019年03月27日 16时13分38秒 星期三 
 * @version:1.0
 */
@Repository
public interface FDStoreDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM f_d_store WHERE ID = :id")
	FDStoreEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param fDStore
	 * @return
	 */
	int update(@Param("fDStore") FDStoreEntity fDStore);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("fDStore") FDStoreEntity fDStore);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param fDStore
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(FDStoreEntity.class)
	public MiniDaoPage<FDStoreEntity> getAll(@Param("fDStore") FDStoreEntity fDStore,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from f_d_store WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from f_d_store WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

