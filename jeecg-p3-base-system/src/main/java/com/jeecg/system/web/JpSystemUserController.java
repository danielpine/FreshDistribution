package com.jeecg.system.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.oConvertUtils;
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
import com.jeecg.system.entity.JpSystemUserEntity;
import com.jeecg.system.service.JpSystemRoleService;
import com.jeecg.system.service.JpSystemUserService;
import com.jeecg.system.util.PasswordUtil;

 /**
 * 描述：用户管理
 * @author: www.jeecg.org
 * @since：2017年08月04日 14时45分53秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/system/jpSystemUser")
public class JpSystemUserController extends BaseController{
  @Autowired
  private JpSystemUserService jpSystemUserService;
  
  @Autowired
  private JpSystemRoleService jpSystemRoleService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute JpSystemUserEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<JpSystemUserEntity> list =  jpSystemUserService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("jpSystemUser",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "jeecg/system/user/jpSystemUser-list.vm";
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
	public void jpSystemUserDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/system/user/jpSystemUser-detail.vm";
			JpSystemUserEntity jpSystemUser = jpSystemUserService.get(id);
			velocityContext.put("jpSystemUser",jpSystemUser);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "jeecg/system/user/jpSystemUser-add.vm";
		 List<JpSystemRoleEntity> roleList = jpSystemRoleService.queryAllRoles();
		 velocityContext.put("roleList",roleList);
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute JpSystemUserEntity jpSystemUser,String roleIds){
		AjaxJson j = new AjaxJson();
		try {
		    String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		    jpSystemUser.setId(randomSeed);
		    jpSystemUser.setDelFlag("0");
		    jpSystemUser.setUserStatus("NORMAL");
		    //update-begin-author:taoYan date:20170811 for:密码加密方法传参顺序问题---
		    jpSystemUser.setPassword(PasswordUtil.encrypt(jpSystemUser.getPassword(), jpSystemUser.getUserName(), PasswordUtil.getStaticSalt()));
		    //update-end-author:taoYan date:20170811 for:密码加密方法传参顺序问题---
		    jpSystemUser.setCreateDate(new Date());
		    if(oConvertUtils.isNotEmpty(roleIds)){
		    	String[] roleIdArr = roleIds.split(",");
		    	jpSystemUserService.addUserAndRole(jpSystemUser, roleIdArr);
		    }else{
		    	jpSystemUserService.addUserAndRole(jpSystemUser, null);
		    }
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
			 JpSystemUserEntity jpSystemUser = jpSystemUserService.get(id);
			 //update-begin-author:taoYan date:20170811 for:编辑页面密码没有解密
			 String pass = jpSystemUser.getPassword();
			 String userName= jpSystemUser.getUserName();
		     String pw = PasswordUtil.decrypt(pass,userName,PasswordUtil.getSalt());
			 jpSystemUser.setPassword(pw);
			 //update-end-author:taoYan date:20170811 for:编辑页面密码没有解密
			 velocityContext.put("jpSystemUser",jpSystemUser);
			 String viewName = "jeecg/system/user/jpSystemUser-edit.vm";
			 List<JpSystemRoleEntity> roleList = jpSystemRoleService.queryAllRoleWithSelect(id);
			 velocityContext.put("roleList",roleList);
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute JpSystemUserEntity jpSystemUser,String roleIds){
		AjaxJson j = new AjaxJson();
		try {
			jpSystemUser.setUpdateDate(new Date());
			//update-begin-author:taoyan date：20170811 for：编辑时密码加密--
			jpSystemUser.setPassword(PasswordUtil.encrypt(jpSystemUser.getPassword(),jpSystemUser.getUserName() , PasswordUtil.getStaticSalt()));
		    //update-end-author:taoyan date：20170811 for：编辑时密码加密--
			if(oConvertUtils.isNotEmpty(roleIds)){
		    	String[] arr = roleIds.split(",");
				jpSystemUserService.updateUserAndRole(jpSystemUser, arr);
		     }else{
		    	 jpSystemUserService.updateUserAndRole(jpSystemUser, null);
		     }
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
			    JpSystemUserEntity jpSystemUser = new JpSystemUserEntity();
				jpSystemUser.setId(id);
				jpSystemUserService.delete(jpSystemUser);
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}
	
	/**
	 * 重置密码页面跳转
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping(params="toResetPassword")
	public void toResetPassword(@RequestParam(required=true)String id,HttpServletRequest request,HttpServletResponse response){
		try {
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("userid", id);
			String viewName = "jeecg/system/user/resetPassword.vm";
			ViewVelocity.view(request, response, viewName, velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 重置用户密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params = "resetPassword")
	@ResponseBody
	public AjaxJson resetPassword(@RequestParam(required=true)String userId,
			@RequestParam(required=true)String password,
			HttpServletRequest request,HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		try {
			JpSystemUserEntity user = jpSystemUserService.get(userId);
			if(user == null){
				ajaxJson.setSuccess(false);
				ajaxJson.setMsg("用户id对应的用户信息未找到");
			}else{
				//update-begin-author:taoYan date:重置密码加密方法---
				user.setPassword(PasswordUtil.encrypt(password,user.getUserName(), PasswordUtil.getStaticSalt()));
				//update-end-author:taoYan date:重置密码加密方法---
				jpSystemUserService.update(user);
				ajaxJson.setMsg("【"+user.getUserName()+"】密码重置成功");
			}
		} catch (Exception e) {
			ajaxJson.setSuccess(false);
			ajaxJson.setMsg(e.getMessage());
		}
		return ajaxJson;
	}
	
	/**
	 * 激活/锁定用户
	 * @param lockValue
	 * @param userid
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "lock")
	@ResponseBody
	public AjaxJson lock(@RequestParam(required=true)String lockValue,@RequestParam(required=true)String userid,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		try {
			JpSystemUserEntity user = jpSystemUserService.get(userid);
			if(user == null){
				ajaxJson.setMsg("用户信息未获取到");
				ajaxJson.setSuccess(false);
			}else if("admin".equals(user.getUserName())){
				ajaxJson.setMsg("【admin】超级管理员不能锁定");
				ajaxJson.setSuccess(false);
			}else{
				//如果传入参数是锁定 并且当前用户是锁定状态
				if("INVALID".equals(lockValue) && "INVALID".equals(user.getUserStatus())){
					ajaxJson.setMsg("【"+user.getUserName()+"】用户已锁定");
				}else if("NORMAL".equals(lockValue) && "NORMAL".equals(user.getUserStatus())){
					//如果传入参数是锁定 并且当前用户是锁定状态
					ajaxJson.setMsg("【"+user.getUserName()+"】用户已激活");
				}else{
					user.setUserStatus(lockValue);
					jpSystemUserService.update(user);
				}
			}
		} catch (Exception e) {
			ajaxJson.setSuccess(false);
			ajaxJson.setMsg(e.getMessage());
		}
		return ajaxJson;
	}
}

