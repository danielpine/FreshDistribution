package com.fresh.core.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.fresh.core.entity.FDGoodsEntity;
import com.fresh.core.entity.FDStoreEntity;
import com.fresh.core.model.DateVo;
import com.fresh.core.model.StoreVo;

/**
 * 描述：商品表
 * 
 * @author：www.jeecg.org
 * @since：2019年03月27日 21时30分42秒 星期三
 * @version:1.0
 */
@Repository
public interface FDQueryDao {

  @ResultType(StoreVo.class)
  public List<StoreVo> getAll(@Param("goods") FDGoodsEntity goods, @Param("dateVo") DateVo dateVo,
      @Param("store") FDStoreEntity store);

}

