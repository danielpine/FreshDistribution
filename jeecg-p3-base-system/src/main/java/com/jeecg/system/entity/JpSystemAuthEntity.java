package com.jeecg.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：菜单管理
 * @author: www.jeecg.org
 * @since：2017年08月06日 10时02分26秒 星期日 
 * @version:1.0
 */
public class JpSystemAuthEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *序号	 */	private String id;	/**	 *权限名称	 */	private String authName;	/**	 *权限类型 0:菜单;1:功能	 */	private String authType;	/**	 *权限说明	 */	private String authDesc;	/**	 *权限控制请求	 */	private String authUrl;	/**	 *上一级权限编码	 */	private String parentId;	/**	 *菜单深度	 */	private String deep;	/**	 *排序	 */	private Integer sortNo;	/**	 *删除标志 0未删除 1已删除	 */	private String delFlag;	/**	 *图标类型	 */	private String iconType;	/**	 *创建人登录名称	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *更新人登录名称	 */	private String updateBy;	/**	 *更新日期	 */	private Date updateDate;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getAuthName() {	    return this.authName;	}	public void setAuthName(String authName) {	    this.authName=authName;	}	public String getAuthType() {	    return this.authType;	}	public void setAuthType(String authType) {	    this.authType=authType;	}	public String getAuthDesc() {	    return this.authDesc;	}	public void setAuthDesc(String authDesc) {	    this.authDesc=authDesc;	}	public String getAuthUrl() {	    return this.authUrl;	}	public void setAuthUrl(String authUrl) {	    this.authUrl=authUrl;	}	public String getParentId() {	    return this.parentId;	}	public void setParentId(String parentId) {	    this.parentId=parentId;	}	public String getDeep() {	    return this.deep;	}	public void setDeep(String deep) {	    this.deep=deep;	}	public Integer getSortNo() {	    return this.sortNo;	}	public void setSortNo(Integer sortNo) {	    this.sortNo=sortNo;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}	public String getIconType() {	    return this.iconType;	}	public void setIconType(String iconType) {	    this.iconType=iconType;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(String updateBy) {	    this.updateBy=updateBy;	}	public Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(Date updateDate) {	    this.updateDate=updateDate;	}
}

