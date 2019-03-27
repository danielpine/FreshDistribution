package com.fresh.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：商品表
 * @author: www.jeecg.org
 * @since：2019年03月27日 16时13分37秒 星期三 
 * @version:1.0
 */
public class FDGoodsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *name	 */	private String name;	/**	 *type	 */	private String type;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}
}

