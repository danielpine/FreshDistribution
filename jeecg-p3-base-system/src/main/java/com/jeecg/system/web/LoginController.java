package com.jeecg.system.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.author.LoginUser;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeecg.system.entity.JpSystemUserEntity;
import com.jeecg.system.service.JpSystemUserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
    private JpSystemUserService jpSystemUserService;
	
	@RequestMapping(params="login")
	public void login(HttpServletRequest request,HttpServletResponse response){
		try {
			VelocityContext velocityContext = new VelocityContext();
			System.out.println("+++++++++++++++++++++++++++++++++++++++");
			String viewName = "jeecg/system/login/login.vm";
			ViewVelocity.view(request, response, viewName, velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 登陆校验用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(params = "checkUser")
	@ResponseBody
	public AjaxJson checkUser(String username,String password,HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		try {
			JpSystemUserEntity user = jpSystemUserService.checkUser(username, password);
			if(user == null){
				ajaxJson.setSuccess(false);
				ajaxJson.setMsg("用户名或者密码错误");
				return ajaxJson;
			}else if("INVALID".equals(user.getUserStatus())){
				ajaxJson.setSuccess(false);
				ajaxJson.setMsg("该用户已被锁定,请联系系统管理员");
				return ajaxJson;
			}else{
				saveLoginInfo(user,request);
			}
			
		} catch (Exception e) {
			ajaxJson.setSuccess(false);
			ajaxJson.setMsg("登陆失败："+e.getMessage());
			e.printStackTrace();
		}
		return ajaxJson;
	}
	/**
	 * 保存登陆信息
	 * @param baseUser
	 * @param departId
	 */
	private void saveLoginInfo(JpSystemUserEntity baseUser,HttpServletRequest request) {
		//登陆成功
		LoginUser user = new LoginUser();
		user.setId(baseUser.getId());
		user.setUserName(baseUser.getUserName());
		user.setUserKey(baseUser.getUserCode());
		user.setDeleteFlag(Short.valueOf(baseUser.getDelFlag()));
		//user.setRealName(baseUser.getRealname());
		HttpSession session = request.getSession();
		session.setAttribute(ContextHolderUtils.LOCAL_CLINET_USER, user);
		/*Client client = ClientManager.getInstance().getClient(session.getId());
		if(client == null || client.getUser() == null || oConvertUtils.isEmpty(client.getUser().getId()) || client.getUser().getUserName().equals(user.getUserName())){
			Client newClient = new Client();
			newClient.setIp(IpUtil.getIpAddr(request));
			newClient.setLogindatetime(new Date());
			newClient.setUser(user);
			ClientManager.getInstance().addClinet(session.getId(), newClient);
		}else{
			ClientManager.getInstance().removeClinet(session.getId());
			session.invalidate();
			session = request.getSession(true);
		}*/
	}

	/**
	 * 退出
	 * @param request
	 * @param response
	 */
	@RequestMapping(params="logout")
	@ResponseBody
	public void logout(HttpServletRequest request,HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(ContextHolderUtils.LOCAL_CLINET_USER);
			session.invalidate();
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/system/login/login.vm";
			ViewVelocity.view(request, response, viewName, velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	
	