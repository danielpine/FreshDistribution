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
public class OrderBadTemResult {
  private Integer gobad;
  private Double transtemperature;
  public Integer getGobad() {
    return gobad;
  }
  public void setGobad(Integer gobad) {
    this.gobad = gobad;
  }
  public Double getTranstemperature() {
    return transtemperature;
  }
  public void setTranstemperature(Double transtemperature) {
    this.transtemperature = transtemperature;
  }
  @Override
  public String toString() {
    return "OrderBadTemResult [gobad=" + gobad + ", transtemperature=" + transtemperature + "]";
  }

}
