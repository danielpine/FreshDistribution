package com.fresh.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 /**
 * 描述：首页
 * @author scott
 * @version:1.0
 */
@Controller
@RequestMapping("/fresh")
public class IndexController extends BaseController{

	/**
	 * 跳转首页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "data",method = {RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
		 try {
			 VelocityContext velocityContext = new VelocityContext();
			 String viewName = "fresh/main/data.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "storage",method = {RequestMethod.GET,RequestMethod.POST})
	public void storage(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
	  try {
	    VelocityContext velocityContext = new VelocityContext();
	    String viewName = "fresh/main/storage.vm";
	    ViewVelocity.view(request,response,viewName,velocityContext);
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}
	@RequestMapping(params = "deliver", method = {RequestMethod.GET, RequestMethod.POST})
	  public void deliver(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	      throws Exception {
	    try {
	      VelocityContext velocityContext = new VelocityContext();
	      System.out.println("deliver");
	      String viewName = "fresh/core/fDGoods-add.vm";
	      ViewVelocity.view(request, response, viewName, velocityContext);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  @RequestMapping(params = "distribution", method = {RequestMethod.GET, RequestMethod.POST})
	  public void distribution(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	      throws Exception {
	    try {
	      VelocityContext velocityContext = new VelocityContext();
	      System.out.println("distribution");
	      String viewName = "fresh/main/index.vm";
	      ViewVelocity.view(request, response, viewName, velocityContext);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  @RequestMapping(params = "backgoods", method = {RequestMethod.GET, RequestMethod.POST})
	  public void backgoods(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	      throws Exception {
	    try {
	      VelocityContext velocityContext = new VelocityContext();
	      System.out.println("backgoods");
	      String viewName = "fresh/core/fDGoods-add.vm";
	      ViewVelocity.view(request, response, viewName, velocityContext);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
