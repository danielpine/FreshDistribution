/**
 * =========================================== Copyright (C) 2018 Finanstar All rights reserved
 *
 * 项 目 名： deri-web 文 件 名： BadInfo.java 版本信息： V1.0.0 作 者： Daniel Pine 日 期： 2019年3月29日-下午1:32:02
 * 
 * ============================================
 */


package com.fresh.core.model;

import java.math.BigDecimal;

/**
 * @描 述：
 * @author:Daniel Pine
 * @联系方式:danielpine@sina.com
 * @date :2019年3月29日-下午1:32:02
 */
public class BadInfo {

  private int badcount = 0;

  private int goodcount = 0;

  public int getBadcount() {
    return badcount;
  }

  public void setBadcount(int badcount) {
    this.badcount = badcount;
  }

  public int getGoodcount() {
    return goodcount;
  }

  public void setGoodcount(int goodcount) {
    this.goodcount = goodcount;
  }

  public void addBadcount() {
    this.badcount += 1;
  }

  public void addGoodcount() {
    this.goodcount += 1;
  }

  public Double getRate() {
    double total = (double) (this.badcount + this.goodcount);
    double rate = 0;
    if (total != 0) {
      rate = new BigDecimal((double) this.badcount * 100 / total)
          .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    return rate;
  }


}
