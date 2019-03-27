		<#if ( jpSystemUser.userCode )?? && jpSystemUser.userCode ?length gt 0>
		    /* 用户编码 */
			and jsu.user_code = :jpSystemUser.userCode
		</#if>
		<#if ( jpSystemUser.userName )?? && jpSystemUser.userName ?length gt 0>
		    /* 用户名称 */
			and jsu.user_name = :jpSystemUser.userName
		</#if>
		<#if ( jpSystemUser.password )?? && jpSystemUser.password ?length gt 0>
		    /* 密码 */
			and jsu.password = :jpSystemUser.password
		</#if>
		<#if ( jpSystemUser.userType )?? && jpSystemUser.userType ?length gt 0>
		    /* 用户种类 */
			and jsu.user_type = :jpSystemUser.userType
		</#if>
		<#if ( jpSystemUser.userStatus )?? && jpSystemUser.userStatus ?length gt 0>
		    /* 用户状态 NORMAL:正常；INVALID：无效 */
			and jsu.user_status = :jpSystemUser.userStatus
		</#if>
	    <#if ( jpSystemUser.lastLognTime )??>
		    /* 上次登录日期 */
			and jsu.last_logn_time = :jpSystemUser.lastLognTime
		</#if>
		<#if ( jpSystemUser.lastLognIp )?? && jpSystemUser.lastLognIp ?length gt 0>
		    /* 上次登录IP */
			and jsu.last_logn_ip = :jpSystemUser.lastLognIp
		</#if>
		<#if ( jpSystemUser.delFlag )?? && jpSystemUser.delFlag ?length gt 0>
		    /* 删除标志 */
			and jsu.del_flag = :jpSystemUser.delFlag
		</#if>
		<#if ( jpSystemUser.createBy )?? && jpSystemUser.createBy ?length gt 0>
		    /* 创建人登录名称 */
			and jsu.create_by = :jpSystemUser.createBy
		</#if>
	    <#if ( jpSystemUser.createDate )??>
		    /* 创建日期 */
			and jsu.create_date = :jpSystemUser.createDate
		</#if>
		<#if ( jpSystemUser.updateBy )?? && jpSystemUser.updateBy ?length gt 0>
		    /* 更新人登录名称 */
			and jsu.update_by = :jpSystemUser.updateBy
		</#if>
	    <#if ( jpSystemUser.updateDate )??>
		    /* 更新日期 */
			and jsu.update_date = :jpSystemUser.updateDate
		</#if>
