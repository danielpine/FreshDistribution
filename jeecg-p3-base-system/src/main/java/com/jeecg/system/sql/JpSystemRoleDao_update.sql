UPDATE jp_system_role
SET 
	   <#if jpSystemRole.roleId ?exists>
		   role_id = :jpSystemRole.roleId,
		</#if>
	   <#if jpSystemRole.roleName ?exists>
		   role_name = :jpSystemRole.roleName,
		</#if>
	   <#if jpSystemRole.delFlag ?exists>
		   del_flag = :jpSystemRole.delFlag,
		</#if>
	   <#if jpSystemRole.createBy ?exists>
		   create_by = :jpSystemRole.createBy,
		</#if>
	    <#if jpSystemRole.createDate ?exists>
		   create_date = :jpSystemRole.createDate,
		</#if>
	   <#if jpSystemRole.updateBy ?exists>
		   update_by = :jpSystemRole.updateBy,
		</#if>
	    <#if jpSystemRole.updateDate ?exists>
		   update_date = :jpSystemRole.updateDate,
		</#if>
WHERE id = :jpSystemRole.id