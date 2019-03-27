SELECT a.id
	  ,a.auth_name as name
	FROM jp_system_auth a 
	join jp_system_role_auth_rel b on a.id = b.auth_id
	join jp_system_role c on c.id = b.role_id
	where a.del_flag = '0' and c.id = :role_id
	