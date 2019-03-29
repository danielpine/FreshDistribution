/**
 * =========================================== Copyright (C) 2018 Finanstar All rights reserved
 *
 * 项 目 名： deri-web 文 件 名： OrderCountResult.java 版本信息： V1.0.0 作 者： Daniel Pine 日 期：
 * 2019年3月29日-上午9:49:22
 * 
 * ============================================
 */


package com.fresh.core.model;

/**
 * @描 述：
 * @author:Daniel Pine
 * @联系方式:danielpine@sina.com
 * @date :2019年3月29日-上午9:49:22
 */
public class OrderCountResult {
  private Integer count;
  private String date;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "OrderCountResult [count=" + count + ", date=" + date + "]";
  }

}
