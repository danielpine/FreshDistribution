UPDATE f_d_goods
SET 
	   <#if fDGoods.gname ?exists>
		   gname = :fDGoods.gname,
		</#if>
	   <#if fDGoods.gtype ?exists>
		   gtype = :fDGoods.gtype,
		</#if>
WHERE id = :fDGoods.id