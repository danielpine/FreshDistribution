SELECT 
si.id,
si.date,
si.goodsid,
si.storeid,
si.count,
fs.location,
fs.name,
fs.type,
fg.gtype,
fg.gname
FROM f_d_store_items si,f_d_store fs,f_d_goods fg  
WHERE si.storeId=fs.id 
AND si.goodsId=fg.id 
AND si.date BETWEEN :dateVo.staDate AND :dateVo.endDate
<#include "FDQueryDao_condition.sql">
ORDER BY si.date,fg.gtype DESC


