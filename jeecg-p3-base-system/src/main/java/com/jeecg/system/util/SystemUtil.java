package com.jeecg.system.util;

import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;

/**
 * Description: 系统工具
 * @author junfeng.zhou
 * @version V1.0
 */
public class SystemUtil {
	 /**
     * 拼树：带checkbox
     * @param allList 所有可用的权限
     * @param roleList  当前角色的权限
     * @return
     */
    public static String initRoleMenuTree(List<Map<String,String>> allList,List<Map<String,String>> roleList) {
        if(allList!=null && allList.size()>0) {
            for (Map<String, String> map : allList) {
            	map.put("pId", map.get("pid"));
            	map.put("checked", "false");
                //判断是否选中
                for(Map<String, String> roleMenu :roleList) {
                   if(roleMenu.get("id").equals(map.get("id"))){
                	   map.put("checked", "true");
                       break;
                   }
                }
			}
            JSONArray jsonArray = JSONArray.fromObject(allList);
            return jsonArray.toString().replace("pid","pId");
        }
        return "";
    }
//  

    
}
