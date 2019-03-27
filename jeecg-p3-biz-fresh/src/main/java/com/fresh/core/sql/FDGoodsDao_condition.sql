		<#if ( fDGoods.gname )?? && fDGoods.gname ?length gt 0>
		    /* gname */
			and fdg.gname = :fDGoods.gname
		</#if>
		<#if ( fDGoods.gtype )?? && fDGoods.gtype ?length gt 0>
		    /* gtype */
			and fdg.gtype = :fDGoods.gtype
		</#if>
