UPDATE f_d_order
SET 
	   <#if fDOrder.backtype ?exists>
		   backType = :fDOrder.backtype,
		</#if>
	   <#if fDOrder.deliveryterminal ?exists>
		   deliveryTerminal = :fDOrder.deliveryterminal,
		</#if>
	   <#if fDOrder.destination ?exists>
		   destination = :fDOrder.destination,
		</#if>
	   <#if fDOrder.gobad ?exists>
		   goBad = :fDOrder.gobad,
		</#if>
	   <#if fDOrder.itemid ?exists>
		   itemId = :fDOrder.itemid,
		</#if>
	   <#if fDOrder.orderdate ?exists>
		   orderDate = :fDOrder.orderdate,
		</#if>
	   <#if fDOrder.orderstatus ?exists>
		   orderStatus = :fDOrder.orderstatus,
		</#if>
	   <#if fDOrder.ordertype ?exists>
		   orderType = :fDOrder.ordertype,
		</#if>
	   <#if fDOrder.transtemperature ?exists>
		   transTemperature = :fDOrder.transtemperature,
		</#if>
	   <#if fDOrder.transtype ?exists>
		   transType = :fDOrder.transtype,
		</#if>
WHERE id = :fDOrder.id