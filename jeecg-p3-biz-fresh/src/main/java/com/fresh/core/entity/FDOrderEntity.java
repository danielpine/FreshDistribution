package com.fresh.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2019年03月28日 18时39分50秒 星期四 
 * @version:1.0
 */
public class FDOrderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *ID	 */	private String id;	/**	 *backType	 */	private String backtype;	/**	 *deliveryTerminal	 */	private String deliveryterminal;	/**	 *destination	 */	private String destination;	/**	 *goBad	 */	private Integer gobad;	/**	 *itemId	 */	private String itemid;	/**	 *orderDate	 */	private String orderdate;	/**	 *orderStatus	 */	private String orderstatus;	/**	 *orderType	 */	private String ordertype;	/**	 *transTemperature	 */	private Double transtemperature;	/**	 *transType	 */	private String transtype;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getBacktype() {	    return this.backtype;	}	public void setBacktype(String backtype) {	    this.backtype=backtype;	}	public String getDeliveryterminal() {	    return this.deliveryterminal;	}	public void setDeliveryterminal(String deliveryterminal) {	    this.deliveryterminal=deliveryterminal;	}	public String getDestination() {	    return this.destination;	}	public void setDestination(String destination) {	    this.destination=destination;	}	public Integer getGobad() {	    return this.gobad;	}	public void setGobad(Integer gobad) {	    this.gobad=gobad;	}	public String getItemid() {	    return this.itemid;	}	public void setItemid(String itemid) {	    this.itemid=itemid;	}	public String getOrderdate() {	    return this.orderdate;	}	public void setOrderdate(String orderdate) {	    this.orderdate=orderdate;	}	public String getOrderstatus() {	    return this.orderstatus;	}	public void setOrderstatus(String orderstatus) {	    this.orderstatus=orderstatus;	}	public String getOrdertype() {	    return this.ordertype;	}	public void setOrdertype(String ordertype) {	    this.ordertype=ordertype;	}	public Double getTranstemperature() {	    return this.transtemperature;	}	public void setTranstemperature(Double transtemperature) {	    this.transtemperature=transtemperature;	}	public String getTranstype() {	    return this.transtype;	}	public void setTranstype(String transtype) {	    this.transtype=transtype;	}
}

