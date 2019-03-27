SELECT count(1) 
	FROM jp_system_auth a
		join jp_system_role_auth_rel b on b.auth_id = a.id
		join jp_system_role c on c.id = b.role_id
		join jp_system_user_role_rel d on d.role_id = c.id
		join jp_system_user e on e.id = d.user_id 
		where e.id = :user_id and a.del_flag = '0' and a.auth_url like CONCAT('%', :url ,'%') 
	