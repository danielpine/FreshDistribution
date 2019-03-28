/**
 * =========================================== Copyright (C) 2018 Finanstar
 * 
 * All rights reserved
 *
 * 项 目 名： deri-web 文 件 名： DateVo.java 版本信息： V1.0.0 作 者： Daniel Pine 日 期： 2019年3月27日-下午8:05:23
 * 
 * ============================================
 */


package com.fresh.core.model;

/**
 * @描 述：
 * @author:Daniel Pine
 * @联系方式:danielpine@sina.com
 * @date :2019年3月27日-下午8:05:23
 */
public class DateVo {
  private String staDate;
  private String endDate;

  public String getStaDate() {
    return staDate;
  }

  public void setStaDate(String staDate) {
    this.staDate = staDate.replace(".", "");
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate.replace(".", "");
  }

  @Override
  public String toString() {
    return "DateVo [staDate=" + staDate + ", endDate=" + endDate + "]";
  }

}
