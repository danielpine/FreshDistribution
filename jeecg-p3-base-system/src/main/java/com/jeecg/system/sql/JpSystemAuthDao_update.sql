UPDATE jp_system_auth
SET 
	   <#if jpSystemAuth.authName ?exists>
		   auth_name = :jpSystemAuth.authName,
		</#if>
	   <#if jpSystemAuth.authType ?exists>
		   auth_type = :jpSystemAuth.authType,
		</#if>
	   <#if jpSystemAuth.authDesc ?exists>
		   auth_desc = :jpSystemAuth.authDesc,
		</#if>
	   <#if jpSystemAuth.authUrl ?exists>
		   auth_url = :jpSystemAuth.authUrl,
		</#if>
	   <#if jpSystemAuth.parentId ?exists>
		   parent_id = :jpSystemAuth.parentId,
		</#if>
	   <#if jpSystemAuth.deep ?exists>
		   deep = :jpSystemAuth.deep,
		</#if>
	   <#if jpSystemAuth.sortNo ?exists>
		   sort_no = :jpSystemAuth.sortNo,
		</#if>
	   <#if jpSystemAuth.delFlag ?exists>
		   del_flag = :jpSystemAuth.delFlag,
		</#if>
	   <#if jpSystemAuth.iconType ?exists>
		   icon_type = :jpSystemAuth.iconType,
		</#if>
	   <#if jpSystemAuth.createBy ?exists>
		   create_by = :jpSystemAuth.createBy,
		</#if>
	    <#if jpSystemAuth.createDate ?exists>
		   create_date = :jpSystemAuth.createDate,
		</#if>
	   <#if jpSystemAuth.updateBy ?exists>
		   update_by = :jpSystemAuth.updateBy,
		</#if>
	    <#if jpSystemAuth.updateDate ?exists>
		   update_date = :jpSystemAuth.updateDate,
		</#if>
WHERE id = :jpSystemAuth.id