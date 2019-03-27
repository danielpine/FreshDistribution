UPDATE f_d_goods
SET 
	   <#if fDGoods.name ?exists>
		   name = :fDGoods.name,
		</#if>
	   <#if fDGoods.gtype ?exists>
		   gtype = :fDGoods.gtype,
		</#if>
WHERE id = :fDGoods.id