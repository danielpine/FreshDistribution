package com.finanstar.market.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**
 * @Title: Entity
 * @Description: 汇率波动率定义
 * @author onlineGenerator
 * @date 2018-03-23 18:25:47
 * @version V1.0
 *
 */
@Entity
@Table(name = "f_d_order", schema = "")
@SuppressWarnings("serial")
public class OrderEntity implements java.io.Serializable {
  /** 主键 */
  private java.lang.String id;
  private java.lang.String orderDate;
  private java.lang.String orderType;
  private java.lang.String itemId;
  private java.lang.String destination;
  private java.lang.String deliveryTerminal;
  private java.lang.String transType;
  private double transTemperature;
  private int goBad;
  private java.lang.String orderStatus;
  private java.lang.String backType;

  /**
   * 方法: 取得java.lang.String
   * 
   * @return: java.lang.String 主键
   */
  @Id
  @GeneratedValue(generator = "paymentableGenerator")
  @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
  @Column(name = "ID", nullable = false, length = 36)
  public java.lang.String getId() {
    return this.id;
  }

  /**
   * 方法: 设置java.lang.String
   * 
   * @param: java.lang.String 主键
   */
  public void setId(java.lang.String id) {
    this.id = id;
  }

  public java.lang.String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(java.lang.String orderDate) {
    this.orderDate = orderDate;
  }

  public java.lang.String getOrderType() {
    return orderType;
  }

  public void setOrderType(java.lang.String orderType) {
    this.orderType = orderType;
  }

  public java.lang.String getItemId() {
    return itemId;
  }

  public void setItemId(java.lang.String itemId) {
    this.itemId = itemId;
  }

  public java.lang.String getDestination() {
    return destination;
  }

  public void setDestination(java.lang.String destination) {
    this.destination = destination;
  }

  public java.lang.String getDeliveryTerminal() {
    return deliveryTerminal;
  }

  public void setDeliveryTerminal(java.lang.String deliveryTerminal) {
    this.deliveryTerminal = deliveryTerminal;
  }

  public java.lang.String getTransType() {
    return transType;
  }

  public void setTransType(java.lang.String transType) {
    this.transType = transType;
  }

  public double getTransTemperature() {
    return transTemperature;
  }

  public void setTransTemperature(double transTemperature) {
    this.transTemperature = transTemperature;
  }

  public int getGoBad() {
    return goBad;
  }

  public void setGoBad(int goBad) {
    this.goBad = goBad;
  }

  public java.lang.String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(java.lang.String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public java.lang.String getBackType() {
    return backType;
  }

  public void setBackType(java.lang.String backType) {
    this.backType = backType;
  }



}
