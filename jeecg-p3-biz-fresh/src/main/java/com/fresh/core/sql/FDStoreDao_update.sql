UPDATE f_d_store
SET 
	   <#if fDStore.location ?exists>
		   location = :fDStore.location,
		</#if>
	   <#if fDStore.name ?exists>
		   name = :fDStore.name,
		</#if>
	   <#if fDStore.type ?exists>
		   type = :fDStore.type,
		</#if>
WHERE id = :fDStore.id