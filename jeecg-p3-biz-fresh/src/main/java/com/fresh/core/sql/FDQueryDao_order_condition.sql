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
		<#if ( pdata.name )?? && pdata.name ?length gt 0>
		    /* name */
			and fs.name = :pdata.name
		</#if>
		<#if ( pdata.type )?? && pdata.type ?length gt 0>
		    /* type */
			and fs.type = :pdata.type
		</#if>
		<#if ( pdata.orderType )?? && pdata.orderType ?length gt 0>
		    /* type */
			and fo.orderType = :pdata.orderType
		</#if>
		<#if ( pdata.transType )?? && pdata.transType ?length gt 0>
		    /* type */
			and fo.transType = :pdata.transType
		</#if>
		<#if ( pdata.destination )?? && pdata.destination ?length gt 0>
		    /* type */
			and fo.destination = :pdata.destination
		</#if>
		<#if ( pdata.tempMin )?? && pdata.tempMin ?length gt 0 && ( pdata.tempMax )?? && pdata.tempMax ?length gt 0>
		    /* type */
			and fo.transTemperature between :pdata.tempMin and :pdata.tempMax
		</#if>

