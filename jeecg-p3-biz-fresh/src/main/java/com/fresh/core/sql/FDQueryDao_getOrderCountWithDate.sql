SELECT 
count(fo.id) count,fo.orderDate date
FROM f_d_order fo,f_d_store_items si,f_d_store fs,f_d_goods fg  
WHERE fo.itemId=si.id  
AND si.goodsId=fg.id 
AND si.storeId=fs.id 
AND fo.orderDate BETWEEN :pdata.staDate AND :pdata.endDate
<#include "FDQueryDao_order_condition.sql">
GROUP BY fo.orderDate
ORDER BY date
