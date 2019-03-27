package com.jeecg.system.interceptors;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecgframework.p3.core.author.LoginUser;
import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.jeecg.system.entity.JpSystemAuthEntity;
import com.jeecg.system.service.JpSystemAuthService;

/**
 * 权限拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
	 
	public final static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
    @Autowired
    private JpSystemAuthService jpSystemAuthService;
	
    List<JpSystemAuthEntity> authList;
    /**
	 * excludeUrls:不进行拦截的url
	 */
	private List<String> excludeUrls;
	private List<String> excludeContainUrls;
	 /**
	 * mode: DEV开发模式(拦截器禁用);PUB发布模式(拦截器启用)
	 */
	private String mode;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<String> getExcludeContainUrls() {
		return excludeContainUrls;
	}

	public void setExcludeContainUrls(List<String> excludeContainUrls) {
		this.excludeContainUrls = excludeContainUrls;
	}

	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}
	
	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		if("DEV1".equals(mode)){
			return true;
		}
		if("login.do".equals(getRequestPath(request))){
			return true;
		}
		String requestPath = getRequestPath2(request);// 用户访问的资源地址
		logger.debug("-------用户访问请求地址-------"+requestPath);
		String basePath = request.getContextPath();
		request.setAttribute("basePath", basePath);
		if(moHuContain(excludeContainUrls,requestPath)) {
			//模糊匹配不拦截
			return true;
		} else if (excludeUrls.contains(requestPath)){
			//如果该请求不在拦截范围内，直接返回true
			return true;
		}else{
			//这个user不会为空。。。。TODO
			//LoginUser user = ContextHolderUtils.getLoginSessionUser();
			LoginUser user = (LoginUser)request.getSession().getAttribute(ContextHolderUtils.LOCAL_CLINET_USER);
			if(user==null){
				String url = basePath+"/login.do?login";
				response.sendRedirect(url);
				return false;
			}
			//检查权限
        	if(!checkUriAuth(requestPath,user.getId())){
        		logger.info("---------无访问权限！----------"+requestPath);
        		response.setStatus(401);
        		return false;
        	}
			return true;
		}
	}
	
	/**
	 * 检查权限
	 */
    private boolean checkUriAuth(String requestPath,String user_id){
    	//user_id = "yonhu";
    	boolean isManagerMenu = false;//是否为后台管理url
		if(authList == null){
			authList = jpSystemAuthService.getAll();
		}
		//判断是否为后台管理url
		for (JpSystemAuthEntity menu : authList) {
			if(oConvertUtils.isNotEmpty(menu.getAuthUrl()) && menu.getAuthUrl().startsWith(requestPath)){
				isManagerMenu = true;
				break;
			}
		}
		if(!isManagerMenu){
			return true;
		}
		//后台管理url  判断当前用户是否有相应权限
		//LoginUser user = ContextHolderUtils.getLoginSessionUser();
		boolean a = jpSystemAuthService.checkLoginUserAuth(user_id,requestPath);
		return a;
    }

	/**
	 * 模糊匹配字符串
	 * @param list
	 * @param key
	 * @return
	 */
	private boolean moHuContain(List<String> list,String key){
		for(String str : list){
//			if(key.contains(str)){
			if(key.startsWith(str)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获得请求路径
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		return requestPath;
	}
	
	 private String getRequestPath2(HttpServletRequest request) {
			String requestPath = request.getRequestURI() + "?" + request.getQueryString();
			if (requestPath.indexOf("&") > -1) {// 去掉其他参数
				requestPath = requestPath.substring(0, requestPath.indexOf("&"));
			}
			requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
			if(requestPath.endsWith("?null")){
				requestPath = requestPath.replace("?null", "");
			}
			return requestPath;
		}

}
