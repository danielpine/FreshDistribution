UPDATE f_d_store_items
SET 
	   <#if fDStoreItems.date ?exists>
		   date = :fDStoreItems.date,
		</#if>
	   <#if fDStoreItems.goodsid ?exists>
		   goodsId = :fDStoreItems.goodsid,
		</#if>
	   <#if fDStoreItems.storeid ?exists>
		   storeId = :fDStoreItems.storeid,
		</#if>
	   <#if fDStoreItems.count ?exists>
		   count = :fDStoreItems.count,
		</#if>
WHERE id = :fDStoreItems.id