package com.jeecg.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：用户管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
public class JpSystemUserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *序号	 */	private String id;	/**	 *用户编码	 */	private String userCode;	/**	 *用户名称	 */	private String userName;	/**	 *密码	 */	private String password;	/**	 *用户种类	 */	private String userType;	/**	 *用户状态 NORMAL:正常；INVALID：无效	 */	private String userStatus;	/**	 *上次登录日期	 */	private Date lastLognTime;	/**	 *上次登录IP	 */	private String lastLognIp;	/**	 *删除标志	 */	private String delFlag;	/**	 *创建人登录名称	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *更新人登录名称	 */	private String updateBy;	/**	 *更新日期	 */	private Date updateDate;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getUserCode() {	    return this.userCode;	}	public void setUserCode(String userCode) {	    this.userCode=userCode;	}	public String getUserName() {	    return this.userName;	}	public void setUserName(String userName) {	    this.userName=userName;	}	public String getPassword() {	    return this.password;	}	public void setPassword(String password) {	    this.password=password;	}	public String getUserType() {	    return this.userType;	}	public void setUserType(String userType) {	    this.userType=userType;	}	public String getUserStatus() {	    return this.userStatus;	}	public void setUserStatus(String userStatus) {	    this.userStatus=userStatus;	}	public Date getLastLognTime() {	    return this.lastLognTime;	}	public void setLastLognTime(Date lastLognTime) {	    this.lastLognTime=lastLognTime;	}	public String getLastLognIp() {	    return this.lastLognIp;	}	public void setLastLognIp(String lastLognIp) {	    this.lastLognIp=lastLognIp;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(String updateBy) {	    this.updateBy=updateBy;	}	public Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(Date updateDate) {	    this.updateDate=updateDate;	}
}

