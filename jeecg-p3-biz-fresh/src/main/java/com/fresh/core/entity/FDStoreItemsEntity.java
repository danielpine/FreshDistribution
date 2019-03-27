package com.fresh.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 17时33分21秒 星期三 
 * @version:1.0
 */
public class FDStoreItemsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *date	 */	private String date;	/**	 *goodsId	 */	private String goodsid;	/**	 *storeId	 */	private String storeid;	/**	 *count	 */	private Integer count;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getDate() {	    return this.date;	}	public void setDate(String date) {	    this.date=date;	}	public String getGoodsid() {	    return this.goodsid;	}	public void setGoodsid(String goodsid) {	    this.goodsid=goodsid;	}	public String getStoreid() {	    return this.storeid;	}	public void setStoreid(String storeid) {	    this.storeid=storeid;	}	public Integer getCount() {	    return this.count;	}	public void setCount(Integer count) {	    this.count=count;	}
  @Override
  public String toString() {
    return "FDStoreItemsEntity [id=" + id + ", date=" + date + ", goodsid=" + goodsid + ", storeid="
        + storeid + ", count=" + count + "]";
  }
	
}

