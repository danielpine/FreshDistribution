SELECT id
	  ,ifNull(parent_id,'0') as pId
	  ,auth_name as name
	FROM jp_system_auth jsa where  del_flag = '0'
order by deep asc