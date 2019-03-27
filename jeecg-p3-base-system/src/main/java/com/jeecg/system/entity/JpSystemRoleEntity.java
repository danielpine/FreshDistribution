package com.jeecg.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：角色管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
public class JpSystemRoleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
		/**	 *序号	 */	private String id;	/**	 *角色编码	 */	private String roleId;	/**	 *角色名称	 */	private String roleName;	/**	 *删除标志	 */	private String delFlag;	/**	 *创建人登录名称	 */	private String createBy;	/**	 *创建日期	 */	private Date createDate;	/**	 *更新人登录名称	 */	private String updateBy;	/**	 *更新日期	 */	private Date updateDate;
	
	/**是否选中1是（非数据库字段）*/
	private String selected;	public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getRoleId() {	    return this.roleId;	}	public void setRoleId(String roleId) {	    this.roleId=roleId;	}	public String getRoleName() {	    return this.roleName;	}	public void setRoleName(String roleName) {	    this.roleName=roleName;	}	public String getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(String delFlag) {	    this.delFlag=delFlag;	}	public String getCreateBy() {	    return this.createBy;	}	public void setCreateBy(String createBy) {	    this.createBy=createBy;	}	public Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(Date createDate) {	    this.createDate=createDate;	}	public String getUpdateBy() {	    return this.updateBy;	}	public void setUpdateBy(String updateBy) {	    this.updateBy=updateBy;	}	public Date getUpdateDate() {	    return this.updateDate;	}	public void setUpdateDate(Date updateDate) {	    this.updateDate=updateDate;	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	
}

