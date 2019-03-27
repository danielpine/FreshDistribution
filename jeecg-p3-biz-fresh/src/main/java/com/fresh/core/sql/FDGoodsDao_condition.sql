		<#if ( fDGoods.name )?? && fDGoods.name ?length gt 0>
		    /* name */
			and fdg.name = :fDGoods.name
		</#if>
		<#if ( fDGoods.type )?? && fDGoods.type ?length gt 0>
		    /* type */
			and fdg.type = :fDGoods.type
		</#if>
