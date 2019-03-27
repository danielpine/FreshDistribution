		<#if ( jpSystemRole.roleId )?? && jpSystemRole.roleId ?length gt 0>
		    /* 角色编码 */
			and jsr.role_id = :jpSystemRole.roleId
		</#if>
		<#if ( jpSystemRole.roleName )?? && jpSystemRole.roleName ?length gt 0>
		    /* 角色名称 */
			and jsr.role_name = :jpSystemRole.roleName
		</#if>
		<#if ( jpSystemRole.delFlag )?? && jpSystemRole.delFlag ?length gt 0>
		    /* 删除标志 */
			and jsr.del_flag = :jpSystemRole.delFlag
		</#if>
		<#if ( jpSystemRole.createBy )?? && jpSystemRole.createBy ?length gt 0>
		    /* 创建人登录名称 */
			and jsr.create_by = :jpSystemRole.createBy
		</#if>
	    <#if ( jpSystemRole.createDate )??>
		    /* 创建日期 */
			and jsr.create_date = :jpSystemRole.createDate
		</#if>
		<#if ( jpSystemRole.updateBy )?? && jpSystemRole.updateBy ?length gt 0>
		    /* 更新人登录名称 */
			and jsr.update_by = :jpSystemRole.updateBy
		</#if>
	    <#if ( jpSystemRole.updateDate )??>
		    /* 更新日期 */
			and jsr.update_date = :jpSystemRole.updateDate
		</#if>
