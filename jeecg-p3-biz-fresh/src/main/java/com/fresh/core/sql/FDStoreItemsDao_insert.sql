INSERT  INTO
	f_d_store_items
      ( 
      ID                            
      ,date                           
      ,goodsId                        
      ,storeId                        
      ,count                          
      ) 
values
      (
      :fDStoreItems.id                            
      ,:fDStoreItems.date                          
      ,:fDStoreItems.goodsid                       
      ,:fDStoreItems.storeid                       
      ,:fDStoreItems.count                         
      )