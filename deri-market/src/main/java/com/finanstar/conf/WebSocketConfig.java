package com.finanstar.conf;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.servlet.http.HttpSession;

import org.apache.catalina.session.StandardSessionFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.finanstar.domain.pojo.RedisTokenValue;

/**
 * 
 * @description： @author： Daniel Pine
 * 
 * @email:danielpine@sina.com @datetime： 2018年12月7日-上午10:11:06
 * @return
 */
@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {
//	private final static Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
	/* 修改握手,就是在握手协议建立之前修改其中携带的内容 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		/* 如果没有监听器,那么这里获取到的HttpSession是null */
		StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
		if (ssf != null) {
			HttpSession session = (HttpSession) request.getHttpSession();
			RedisTokenValue userInfo = (RedisTokenValue) session.getAttribute(KeyResource.TOKEN_VALUE);
			sec.getUserProperties().put("userInfo", userInfo);
		}
		super.modifyHandshake(sec, request, response);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
