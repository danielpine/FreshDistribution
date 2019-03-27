		<#if ( jpSystemAuth.authName )?? && jpSystemAuth.authName ?length gt 0>
		    /* 权限名称 */
			and jsa.auth_name = :jpSystemAuth.authName
		</#if>
		<#if ( jpSystemAuth.authType )?? && jpSystemAuth.authType ?length gt 0>
		    /* 权限类型 0:菜单;1:功能 */
			and jsa.auth_type = :jpSystemAuth.authType
		</#if>
		<#if ( jpSystemAuth.authDesc )?? && jpSystemAuth.authDesc ?length gt 0>
		    /* 权限说明 */
			and jsa.auth_desc = :jpSystemAuth.authDesc
		</#if>
		<#if ( jpSystemAuth.authUrl )?? && jpSystemAuth.authUrl ?length gt 0>
		    /* 权限控制请求 */
			and jsa.auth_url = :jpSystemAuth.authUrl
		</#if>
		<#if ( jpSystemAuth.parentId )?? && jpSystemAuth.parentId ?length gt 0>
		    /* 上一级权限编码 */
			and jsa.parent_id = :jpSystemAuth.parentId
		</#if>
		<#if ( jpSystemAuth.deep )?? && jpSystemAuth.deep ?length gt 0>
		    /* 菜单深度 */
			and jsa.deep = :jpSystemAuth.deep
		</#if>
		<#if ( jpSystemAuth.sortNo )?? && jpSystemAuth.sortNo ?length gt 0>
		    /* 排序 */
			and jsa.sort_no = :jpSystemAuth.sortNo
		</#if>
		<#if ( jpSystemAuth.delFlag )?? && jpSystemAuth.delFlag ?length gt 0>
		    /* 删除标志 0未删除 1已删除 */
			and jsa.del_flag = :jpSystemAuth.delFlag
		</#if>
		<#if ( jpSystemAuth.iconType )?? && jpSystemAuth.iconType ?length gt 0>
		    /* 图标类型 */
			and jsa.icon_type = :jpSystemAuth.iconType
		</#if>
		<#if ( jpSystemAuth.createBy )?? && jpSystemAuth.createBy ?length gt 0>
		    /* 创建人登录名称 */
			and jsa.create_by = :jpSystemAuth.createBy
		</#if>
	    <#if ( jpSystemAuth.createDate )??>
		    /* 创建日期 */
			and jsa.create_date = :jpSystemAuth.createDate
		</#if>
		<#if ( jpSystemAuth.updateBy )?? && jpSystemAuth.updateBy ?length gt 0>
		    /* 更新人登录名称 */
			and jsa.update_by = :jpSystemAuth.updateBy
		</#if>
	    <#if ( jpSystemAuth.updateDate )??>
		    /* 更新日期 */
			and jsa.update_date = :jpSystemAuth.updateDate
		</#if>
