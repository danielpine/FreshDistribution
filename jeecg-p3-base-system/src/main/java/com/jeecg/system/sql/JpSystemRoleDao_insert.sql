INSERT  INTO
	jp_system_role
      ( 
      id                            
      ,role_id                        
      ,role_name                      
      ,del_flag                       
      ,create_by                      
      ,create_date                    
      ,update_by                      
      ,update_date                    
      ) 
values
      (
      :jpSystemRole.id                            
      ,:jpSystemRole.roleId                        
      ,:jpSystemRole.roleName                      
      ,:jpSystemRole.delFlag                       
      ,:jpSystemRole.createBy                      
      ,:jpSystemRole.createDate                    
      ,:jpSystemRole.updateBy                      
      ,:jpSystemRole.updateDate                    
      )