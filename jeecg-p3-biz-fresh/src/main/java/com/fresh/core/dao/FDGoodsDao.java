package com.fresh.core.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.fresh.core.entity.FDGoodsEntity;

/**
 * 描述：商品表
 * @author：www.jeecg.org
 * @since：2019年03月27日 21时30分42秒 星期三 
 * @version:1.0
 */
@Repository
public interface FDGoodsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM f_d_goods WHERE ID = :id")
	FDGoodsEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param fDGoods
	 * @return
	 */
	int update(@Param("fDGoods") FDGoodsEntity fDGoods);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("fDGoods") FDGoodsEntity fDGoods);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param fDGoods
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(FDGoodsEntity.class)
	public MiniDaoPage<FDGoodsEntity> getAll(@Param("fDGoods") FDGoodsEntity fDGoods,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from f_d_goods WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from f_d_goods WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

