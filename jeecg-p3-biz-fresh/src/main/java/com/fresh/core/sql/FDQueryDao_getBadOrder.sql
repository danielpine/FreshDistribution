SELECT 
fo.transtemperature ,fo.gobad 
FROM f_d_order fo,f_d_store_items si,f_d_store fs,f_d_goods fg  
WHERE fo.itemId=si.id  
AND si.goodsId=fg.id 
AND si.storeId=fs.id 
AND fo.orderDate BETWEEN :pdata.staDate AND :pdata.endDate
<#include "FDQueryDao_order_condition.sql">
<#if ( pdata.deliveryterminal )?? && pdata.deliveryterminal ?length gt 0>
AND fo.deliveryTerminal = :pdata.deliveryterminal
</#if>
ORDER BY transtemperature
