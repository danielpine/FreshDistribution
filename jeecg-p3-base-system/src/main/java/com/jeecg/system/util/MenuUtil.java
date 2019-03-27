package com.jeecg.system.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jeecgframework.p3.core.util.oConvertUtils;
import org.jeecgframework.p3.core.util.plugin.ContextHolderUtils;

import com.jeecg.system.entity.JpSystemAuthEntity;

public class MenuUtil {

	/**HTTP请求链接的判断正则*/
	public static String httpRegex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
	/**菜单的最大层级*/
	public static final int MENU_MAX_LEVEL = 3;
	/**
	 * 菜单拼接
	 * @param list
	 * @param pid
	 * @param level
	 * @return
	 */
	public static String combineHtml(List<JpSystemAuthEntity> list,String pid,int level){
		String basePath = ContextHolderUtils.getRequest().getContextPath();
		StringBuffer a = new StringBuffer();
		for (JpSystemAuthEntity menu : list) {
			String pId = menu.getParentId();
			if(pid.equals(pId)){
				a.append(getSingleMenu(menu, level,basePath));
				String subHtml=combineHtml(list, menu.getId(), level+1);
				a.append(subHtml);
				if(level<MENU_MAX_LEVEL){
					a.append("</ul></li>");
				}
			}
		}
		return a.toString();
	}
	
	/**
	 * 单个菜单html片段
	 * @param menu
	 * @param level
	 * @param basePath
	 * @return
	 */
	private static String getSingleMenu(JpSystemAuthEntity menu,int level,String basePath){
		String m="";
		String menuName=menu.getAuthName();
		String icon = menu.getIconType();
		String font = oConvertUtils.isEmpty(icon)?"fa fa-columns":"fa "+icon;
		Integer sort = menu.getSortNo();
		String url = getHref(menu.getAuthUrl(), basePath);
		if(level == 1){
			m="<li><a href='#' class=''><i class='"+font+"'></i><span class='menu-text'>"+menuName+"</span><span class='fa arrow'></span></a><ul class='nav nav-second-level collapse'>";
		}else if(level >= 2 && level < MENU_MAX_LEVEL){
			if("".equals(url)){
				m="<li><a href class=''><i class='"+font+"'></i><span class='menu-text'>"+menuName+"</span><span class='fa arrow'></span></a><ul class='nav nav-third-level collapse'>";
			}else{
				m="<li><a class='J_menuItem' href='"+url+"' data-index='"+(sort-1)+"'>"+menuName+"</a><ul class='nav nav-second-level collapse'>";
			}
		}else if(level==MENU_MAX_LEVEL){
			m="<li><a class='J_menuItem' href"+(!"".equals(url)?("='"+url+"'"):"")+" data-index='"+(sort-1)+"'>"+menuName+"</a></li>";
		}
		return m;
	}
	
	/***
	 * 获取菜单href
	 * @param authUrl
	 * @param basePath
	 * @return
	 */
	private static String getHref(String authUrl,String basePath){
		Pattern pattern = Pattern.compile(httpRegex);
		Matcher matcher = pattern.matcher(authUrl);
		if(oConvertUtils.isEmpty(authUrl)){
			//如果是空返回空串
			return "";
		}else if(matcher.matches()){
			//如果是网址直接返回
			return authUrl;
		}else if(authUrl.indexOf(".do")<0){
			//如果没有请求链接中.do则直接返回空串
			return "";
		}else{
			return basePath+"/"+authUrl;
		}
	}
	
}
