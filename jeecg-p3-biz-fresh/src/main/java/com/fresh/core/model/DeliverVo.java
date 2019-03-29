/**
 * =========================================== Copyright (C) 2018 Finanstar All rights reserved
 *
 * 项 目 名： deri-web 文 件 名： DeliverVo.java 版本信息： V1.0.0 作 者： Daniel Pine 日 期： 2019年3月29日-上午9:39:50
 * 
 * ============================================
 */


package com.fresh.core.model;

import com.alibaba.fastjson.JSON;

/**
 * @描 述：
 * @author:Daniel Pine
 * @联系方式:danielpine@sina.com
 * @date :2019年3月29日-上午9:39:50
 */
public class DeliverVo {
  private String staDate;
  private String endDate;
  private String gtype;
  private String gname;
  private String location;
  private String type;
  private String name;
  private String orderType;
  private String transType;
  private String destination;
  private Double tempMin;
  private Double tempMax;
  private String deliveryterminal;
  private String backtype;

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

  public String getGtype() {
    return gtype;
  }

  public void setGtype(String gtype) {
    this.gtype = gtype;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getTransType() {
    return transType;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Double getTempMin() {
    return tempMin;
  }

  public void setTempMin(Double tempMin) {
    this.tempMin = tempMin;
  }

  public Double getTempMax() {
    return tempMax;
  }

  public void setTempMax(Double tempMax) {
    this.tempMax = tempMax;
  }

  
  public String getDeliveryterminal() {
    return deliveryterminal;
  }

  public void setDeliveryterminal(String deliveryterminal) {
    this.deliveryterminal = deliveryterminal;
  }
  
  public String getBacktype() {
    return backtype;
  }

  public void setBacktype(String backtype) {
    this.backtype = backtype;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this, true);
  }



}
