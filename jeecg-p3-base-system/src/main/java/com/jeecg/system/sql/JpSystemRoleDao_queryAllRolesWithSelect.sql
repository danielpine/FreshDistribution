SELECT a.id,
	   a.role_name,
	   (case when b.user_id IS NOT NULL then '1' end) as selected
	FROM jp_system_role a
	left join (select * from jp_system_user_role_rel where user_id = :user_id) b on a.id = b.role_id
	WHERE a.del_flag = '0' 