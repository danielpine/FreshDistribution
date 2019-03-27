package com.jeecg.system.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.common.utils.StringUtil;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.system.entity.JpSystemAuthEntity;
import com.jeecg.system.service.JpSystemAuthService;
import net.sf.json.JSONArray;

 /**
 * 描述：菜单管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 16时30分27秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/system/jpSystemAuth")
public class JpSystemAuthController extends BaseController{
  @Autowired
  private JpSystemAuthService jpSystemAuthService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute JpSystemAuthEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "100") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
			 	pageSize = 100;
				MiniDaoPage<JpSystemAuthEntity> list =  jpSystemAuthService.getDeepAll(query,pageNo,pageSize);
				 //update-begin--Author:chenqian  Date:20170904 for #2333 【插件-我的文档】我的文档 - 权限设置--------------------
				List<JpSystemAuthEntity> targetList = new ArrayList<JpSystemAuthEntity>();
				List<JpSystemAuthEntity> sourceList = list.getResults();
				for (JpSystemAuthEntity root: sourceList) {
					if (StringUtil.isEmpty(root.getParentId())||"0".equals( root.getParentId())) {
						targetList.add(root);//获取根节点
						sortChild(root,sourceList,targetList);//递归子节点
					}
				}
				list.setResults(targetList);
				 //update-end--Author:chenqian  Date:20170904 for #2333 【插件-我的文档】我的文档 - 权限设置--------------------				
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("jpSystemAuth",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/system/menu/jpSystemAuth-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
			e.printStackTrace();
			}
}
	
	 //update-begin--Author:chenqian  Date:20170904 for #2333 【插件-我的文档】我的文档 - 权限设置--------------------
	/**
	 * 子节点排序
	 * @param parent
	 * @param sourceList
	 * @param targetList
	 */
	private void sortChild(JpSystemAuthEntity parent,List<JpSystemAuthEntity> sourceList,List<JpSystemAuthEntity> targetList){
		for (JpSystemAuthEntity child: sourceList) {
			if (child.getParentId().equals(parent.getId())) {
				targetList.add(child);
				sortChild(child,sourceList,targetList);
			}
		}
	}
	//update-end--Author:chenqian  Date:20170904 for #2333 【插件-我的文档】我的文档 - 权限设置--------------------
	
	@RequestMapping(value="/getAuthTree",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public AjaxJson getAuthTree(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j=new AjaxJson();
	    try {
	    	//ztree同步加载
	    	JSONArray jsonArray=JSONArray.fromObject(jpSystemAuthService.getMenuTree());
	    	j.setObj(jsonArray.toString().replaceAll("pid","pId"));
	        log.info("权限树: " + jsonArray.toString());
	    }catch (Exception e){
	    	j.setSuccess(false);
	    	j.setMsg(e.getMessage());
	    	log.info(e.getMessage());
	    }
	    return j;
	}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void jpSystemAuthDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/system/menu/jpSystemAuth-detail.vm";
			JpSystemAuthEntity jpSystemAuth = jpSystemAuthService.get(id);
			velocityContext.put("jpSystemAuth",jpSystemAuth);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(String node,HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "jeecg/system/menu/jpSystemAuth-add.vm";
		 velocityContext.put("node", node);
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JpSystemAuthEntity jpSystemAuth){
		AjaxJson j = new AjaxJson();
		try {
		    String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		    jpSystemAuth.setId(randomSeed);
		    jpSystemAuth.setDelFlag("0");
			jpSystemAuthService.insert(jpSystemAuth);
			j.setMsg("保存成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 JpSystemAuthEntity jpSystemAuth = jpSystemAuthService.get(id);
			 velocityContext.put("jpSystemAuth",jpSystemAuth);
			 String viewName = "jeecg/system/menu/jpSystemAuth-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JpSystemAuthEntity jpSystemAuth){
		AjaxJson j = new AjaxJson();
		try {
			jpSystemAuthService.update(jpSystemAuth);
			j.setMsg("编辑成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				//先判断是否有子菜单
			    boolean abc = jpSystemAuthService.hasSubNode(id);
			    if(abc){
			    	j.setMsg("请先删除子菜单！");
			    	j.setSuccess(false);
			    }else{
			    	JpSystemAuthEntity jpSystemAuth = new JpSystemAuthEntity();
			    	jpSystemAuth.setId(id);
					jpSystemAuthService.delete(jpSystemAuth);
					j.setMsg("删除成功");
			    }
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}


}

