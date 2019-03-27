package com.jeecg.system.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
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
import com.jeecg.system.entity.JpSystemRoleEntity;
import com.jeecg.system.service.JpSystemAuthService;
import com.jeecg.system.service.JpSystemRoleService;
import com.jeecg.system.util.SystemUtil;

 /**
 * 描述：角色管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/system/jpSystemRole")
public class JpSystemRoleController extends BaseController{
  @Autowired
  private JpSystemRoleService jpSystemRoleService;
  
  @Autowired
  private JpSystemAuthService jpSystemAuthService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute JpSystemRoleEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<JpSystemRoleEntity> list =  jpSystemRoleService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("jpSystemRole",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/system/role/jpSystemRole-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
			e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void jpSystemRoleDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
		VelocityContext velocityContext = new VelocityContext();
		String viewName = "jeecg/system/role/jpSystemRole-detail.vm";
		JpSystemRoleEntity jpSystemRole = jpSystemRoleService.get(id);
		velocityContext.put("jpSystemRole",jpSystemRole);
		ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "jeecg/system/role/jpSystemRole-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JpSystemRoleEntity jpSystemRole){
		AjaxJson j = new AjaxJson();
		try {
		    String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		    jpSystemRole.setId(randomSeed);
		    //update-begin-author:taoYan date:20170811 for:默认设置删除状态值为0--
		    jpSystemRole.setDelFlag("0");
		    //update-end-author:taoYan date:20170811 for:默认设置删除状态值为0--
			jpSystemRoleService.insert(jpSystemRole);
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
			 JpSystemRoleEntity jpSystemRole = jpSystemRoleService.get(id);
			 velocityContext.put("jpSystemRole",jpSystemRole);
			 String viewName = "jeecg/system/role/jpSystemRole-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JpSystemRoleEntity jpSystemRole){
		AjaxJson j = new AjaxJson();
		try {
			jpSystemRoleService.update(jpSystemRole);
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
			    JpSystemRoleEntity jpSystemRole = new JpSystemRoleEntity();
				jpSystemRole.setId(id);
				jpSystemRoleService.delete(jpSystemRole);
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}

	
	/**
	 * 跳转到菜单-角色界面
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="toPrivilegeTree",method = RequestMethod.GET)
	public void toPrivilegeTree(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 JpSystemRoleEntity role = jpSystemRoleService.get(id);
			 velocityContext.put("role",role);
			 String viewName = "jeecg/system/role/role-menu-tree.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}
	
	/**
	 * 初始化权限
	 */
	@RequestMapping(value="/initAuth",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String initAuth(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "roleId", required = true) String roleId) {
		log.info("初始化权限");
		String tree = "";
	    try {
	        //所有可用的权限
	    	List<Map<String, String>> allMenu = jpSystemAuthService.getMenuTree();
	        //当前角色的权限
	    	//roleId 为主键id
	    	List<Map<String, String>> roleMenu = jpSystemRoleService.getRoleMenu(roleId);
	       
	        tree = SystemUtil.initRoleMenuTree(allMenu,roleMenu);
	        log.info("初始化权限: " + tree);
	    }catch (Exception e){
	    	log.info(e.getMessage());
	    }
	    return tree;
	}
	
	/**
	 * 编辑角色权限
	 */
	@RequestMapping(value = "/editRoleAuth",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson editRoleAuth(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "checkedNodes", required = true) String checkedNodes,
			@RequestParam(value = "roleId", required = true) String roleId) {
		AjaxJson j = new AjaxJson();
		log.info("编辑角色权限");
		try {
			String[] menuIds = checkedNodes.split(",");
			jpSystemRoleService.updateRoleMenu(roleId,menuIds);
			j.setSuccess(true);
			j.setMsg("角色授权成功");
			log.info("编辑角色权限完成 ");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("角色授权失败");
		}
		return j;
	}
	
	

}

