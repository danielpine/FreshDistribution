SELECT 
count(fo.id) value ,fo.backtype name
FROM f_d_order fo,f_d_store_items si,f_d_store fs,f_d_goods fg  
WHERE fo.itemId=si.id  
AND si.goodsId=fg.id 
AND si.storeId=fs.id 
AND fo.orderDate BETWEEN :pdata.staDate AND :pdata.endDate
and fo.orderStatus = '退货'
<#include "FDQueryDao_back_condition.sql">
GROUP BY fo.backtype
