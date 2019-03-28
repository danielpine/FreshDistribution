package com.fresh.core.model;

/**
 * @描 述：
 * @author:Daniel Pine
 * @联系方式:danielpine@sina.com
 * @date :2019年3月28日-上午9:15:33
 */
public class StoreVo {
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
  /**
   * location
   */
  private String location;
  /**
   * name
   */
  private String name;
  /**
   * type
   */
  private String type;
  /**
   * date
   */
  private String date;
  /**
   * goodsId
   */
  private String goodsid;
  /**
   * storeId
   */
  private String storeid;
  /**
   * count
   */
  private Integer count;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public String getGtype() {
    return gtype;
  }

  public void setGtype(String gtype) {
    this.gtype = gtype;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getGoodsid() {
    return goodsid;
  }

  public void setGoodsid(String goodsid) {
    this.goodsid = goodsid;
  }

  public String getStoreid() {
    return storeid;
  }

  public void setStoreid(String storeid) {
    this.storeid = storeid;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "StoreVo [id=" + id + ", gname=" + gname + ", gtype=" + gtype + ", location=" + location
        + ", name=" + name + ", type=" + type + ", date=" + date + ", goodsid=" + goodsid
        + ", storeid=" + storeid + ", count=" + count + "]";
  }

}
