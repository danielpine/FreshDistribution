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
import com.fresh.core.model.DeliverVo;
import com.fresh.core.model.OrderBackResult;
import com.fresh.core.model.OrderBadTemResult;
import com.fresh.core.model.OrderCountResult;
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

  /**
   * @方法描述：
   * 
   * @作 者： Daniel Pine
   * @日 期： 2019年3月29日-上午9:47:56
   * @return
   */
  public List<OrderCountResult> getOrderCountWithDate(@Param("pdata") DeliverVo pdata);

  /**
   * @方法描述：
   * 
   * @作 者： Daniel Pine
   * @日 期： 2019年3月29日-上午11:50:08
   * @return
   */
  public List<OrderBadTemResult> getBadOrder(@Param("pdata") DeliverVo pdata);

  /**
   *  @方法描述： 
   *  @作       者： Daniel Pine
   *  @日       期： 2019年3月29日-下午2:58:48
   *  @return
   */
  public List<OrderBackResult> getBack(@Param("pdata") DeliverVo pdata);

}

