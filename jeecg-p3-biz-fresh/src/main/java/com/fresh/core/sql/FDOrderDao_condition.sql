		<#if ( fDOrder.backtype )?? && fDOrder.backtype ?length gt 0>
		    /* backType */
			and fdo.backType = :fDOrder.backtype
		</#if>
		<#if ( fDOrder.deliveryterminal )?? && fDOrder.deliveryterminal ?length gt 0>
		    /* deliveryTerminal */
			and fdo.deliveryTerminal = :fDOrder.deliveryterminal
		</#if>
		<#if ( fDOrder.destination )?? && fDOrder.destination ?length gt 0>
		    /* destination */
			and fdo.destination = :fDOrder.destination
		</#if>
		<#if ( fDOrder.gobad )?? && fDOrder.gobad ?length gt 0>
		    /* goBad */
			and fdo.goBad = :fDOrder.gobad
		</#if>
		<#if ( fDOrder.itemid )?? && fDOrder.itemid ?length gt 0>
		    /* itemId */
			and fdo.itemId = :fDOrder.itemid
		</#if>
		<#if ( fDOrder.orderdate )?? && fDOrder.orderdate ?length gt 0>
		    /* orderDate */
			and fdo.orderDate = :fDOrder.orderdate
		</#if>
		<#if ( fDOrder.orderstatus )?? && fDOrder.orderstatus ?length gt 0>
		    /* orderStatus */
			and fdo.orderStatus = :fDOrder.orderstatus
		</#if>
		<#if ( fDOrder.ordertype )?? && fDOrder.ordertype ?length gt 0>
		    /* orderType */
			and fdo.orderType = :fDOrder.ordertype
		</#if>
		<#if ( fDOrder.transtemperature )?? && fDOrder.transtemperature ?length gt 0>
		    /* transTemperature */
			and fdo.transTemperature = :fDOrder.transtemperature
		</#if>
		<#if ( fDOrder.transtype )?? && fDOrder.transtype ?length gt 0>
		    /* transType */
			and fdo.transType = :fDOrder.transtype
		</#if>
