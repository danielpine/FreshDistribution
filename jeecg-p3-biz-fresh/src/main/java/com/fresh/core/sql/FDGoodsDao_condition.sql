		<#if ( fDGoods.name )?? && fDGoods.name ?length gt 0>
		    /* name */
			and fdg.name = :fDGoods.name
		</#if>
		<#if ( fDGoods.gtype )?? && fDGoods.gtype ?length gt 0>
		    /* gtype */
			and fdg.gtype = :fDGoods.gtype
		</#if>
