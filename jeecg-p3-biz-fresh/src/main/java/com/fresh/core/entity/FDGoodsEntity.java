package com.fresh.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：商品表
 * 
 * @author: www.jeecg.org
 * @since：2019年03月27日 21时30分42秒 星期三
 * @version:1.0
 */
public class FDGoodsEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * ID
   */
  private String id;
  /**
   * gname
   */
  private String gname;
  /**
   * gtype
   */
  private String gtype;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGname() {
    return this.gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public String getGtype() {
    return this.gtype;
  }

  public void setGtype(String gtype) {
    this.gtype = gtype;
  }

  @Override
  public String toString() {
    return "FDGoodsEntity [id=" + id + ", gname=" + gname + ", gtype=" + gtype + "]";
  }


}

