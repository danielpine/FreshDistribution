		<#if ( fDStoreItems.date )?? && fDStoreItems.date ?length gt 0>
		    /* date */
			and fdsi.date = :fDStoreItems.date
		</#if>
		<#if ( fDStoreItems.goodsid )?? && fDStoreItems.goodsid ?length gt 0>
		    /* goodsId */
			and fdsi.goodsId = :fDStoreItems.goodsid
		</#if>
		<#if ( fDStoreItems.storeid )?? && fDStoreItems.storeid ?length gt 0>
		    /* storeId */
			and fdsi.storeId = :fDStoreItems.storeid
		</#if>
		<#if ( fDStoreItems.count )?? && fDStoreItems.count ?length gt 0>
		    /* count */
			and fdsi.count = :fDStoreItems.count
		</#if>
