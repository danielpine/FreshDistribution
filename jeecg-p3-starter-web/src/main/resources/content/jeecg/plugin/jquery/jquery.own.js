function commonTip(msg,icon,callback){
	//icon 0 叹号 1对号 2叉号3问号4章5哭脸6笑脸
	parent.layer.alert(msg, {
        icon: icon,
        shadeClose: false,
        title: '提示'
    },function(index){
    	parent.layer.close(index);
    	if(!!callback){
    		callback();
    	}
    });
}