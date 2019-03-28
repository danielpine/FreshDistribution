		<#if ( goods.gtype )?? && goods.gtype ?length gt 0>
		    /* gtype */
			and fg.gtype = :goods.gtype
		</#if>
		<#if ( goods.gname )?? && goods.gname ?length gt 0>
		    /* gname */
			and fg.gname = :goods.gname
		</#if>
				<#if ( store.location )?? && store.location ?length gt 0>
		    /* location */
			and fs.location = :store.location
		</#if>
		<#if ( store.name )?? && store.name ?length gt 0>
		    /* name */
			and fs.name = :store.name
		</#if>
		<#if ( store.type )?? && store.type ?length gt 0>
		    /* type */
			and fs.type = :store.type
		</#if>

