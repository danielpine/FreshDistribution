UPDATE jp_system_user
SET 
	   <#if jpSystemUser.userCode ?exists>
		   user_code = :jpSystemUser.userCode,
		</#if>
	   <#if jpSystemUser.userName ?exists>
		   user_name = :jpSystemUser.userName,
		</#if>
	   <#if jpSystemUser.password ?exists>
		   password = :jpSystemUser.password,
		</#if>
	   <#if jpSystemUser.userType ?exists>
		   user_type = :jpSystemUser.userType,
		</#if>
	   <#if jpSystemUser.userStatus ?exists>
		   user_status = :jpSystemUser.userStatus,
		</#if>
	    <#if jpSystemUser.lastLognTime ?exists>
		   last_logn_time = :jpSystemUser.lastLognTime,
		</#if>
	   <#if jpSystemUser.lastLognIp ?exists>
		   last_logn_ip = :jpSystemUser.lastLognIp,
		</#if>
	   <#if jpSystemUser.delFlag ?exists>
		   del_flag = :jpSystemUser.delFlag,
		</#if>
	   <#if jpSystemUser.createBy ?exists>
		   create_by = :jpSystemUser.createBy,
		</#if>
	    <#if jpSystemUser.createDate ?exists>
		   create_date = :jpSystemUser.createDate,
		</#if>
	   <#if jpSystemUser.updateBy ?exists>
		   update_by = :jpSystemUser.updateBy,
		</#if>
	    <#if jpSystemUser.updateDate ?exists>
		   update_date = :jpSystemUser.updateDate,
		</#if>
WHERE id = :jpSystemUser.id