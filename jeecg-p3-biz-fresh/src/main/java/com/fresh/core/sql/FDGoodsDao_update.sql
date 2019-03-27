UPDATE f_d_goods
SET 
	   <#if fDGoods.name ?exists>
		   name = :fDGoods.name,
		</#if>
	   <#if fDGoods.type ?exists>
		   type = :fDGoods.type,
		</#if>
WHERE id = :fDGoods.id