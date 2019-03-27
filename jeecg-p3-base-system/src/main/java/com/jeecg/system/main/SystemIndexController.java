package com.jeecg.system.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeecg.system.service.JpSystemAuthService;

 /**
 * 描述：首页
 * @author scott
 * @version:1.0
 */
@Controller
@RequestMapping("/system/index")
public class SystemIndexController extends BaseController{

	@Autowired
	private JpSystemAuthService jpSystemAuthService;
	/**
	 * 跳转首页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		 try {
			 VelocityContext velocityContext = new VelocityContext();
			 String viewName = "system/main/index.vm";
			 String menuHtml = jpSystemAuthService.initMenu();
			 velocityContext.put("menuHtmlzz", menuHtml);
			 ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
