		<#if ( pdata.gtype )?? && pdata.gtype ?length gt 0>
		    /* gtype */
			and fg.gtype = :pdata.gtype
		</#if>
		<#if ( pdata.gname )?? && pdata.gname ?length gt 0>
		    /* gname */
			and fg.gname = :pdata.gname
		</#if>
				<#if ( pdata.location )?? && pdata.location ?length gt 0>
		    /* location */
			and fs.location = :pdata.location
		</#if>
		<#if ( pdata.type )?? && pdata.type ?length gt 0>
		    /* type */
			and fs.type = :pdata.type
		</#if>
		<#if ( pdata.backtype )?? && pdata.backtype ?length gt 0>
			AND fo.backtype = :pdata.backtype
		</#if>
