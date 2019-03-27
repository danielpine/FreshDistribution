package com.finanstar.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.finanstar.conf.WebSocketConfig;
import com.finanstar.domain.enums.ResultEnum;
import com.finanstar.domain.pojo.RedisTokenValue;
import com.finanstar.util.ResultUtil;

@ServerEndpoint(value = "/websocket", configurator = WebSocketConfig.class)
@Component
public class MyWebSocket {

	private final static Logger logger = LoggerFactory.getLogger(MyWebSocket.class);
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	public static Map<String, ConcurrentHashMap<String, MyWebSocket>> webSocketMap = new ConcurrentHashMap<>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	private RedisTokenValue userInfo;

	/**
	 * 连接建立成功调用的方法
	 * 
	 * @throws Exception
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws Exception {
		this.userInfo = (RedisTokenValue) config.getUserProperties().get("userInfo");
		if (userInfo == null) {
			throw new Exception(ResultEnum.NOT_LOGIN.getMsg());
		}
		logger.info("config:{}", userInfo);
		this.session = session;
		ConcurrentHashMap<String, MyWebSocket> compMap = webSocketMap.get(userInfo.getCompanyCode());
		// { compcode:{uername:websocket}}
		if (compMap == null) {
			compMap = new ConcurrentHashMap<String, MyWebSocket>();
			webSocketMap.put(userInfo.getCompanyCode(), compMap);
		}
		compMap.put(userInfo.getUserName(), this); // 加入set中
		addOnlineCount(); // 在线数加1
		logger.info("webSocketMap:{}", JSON.toJSONString(webSocketMap));
		logger.info("有新连接加入！当前在线人数为" + getOnlineCount());
		try {
			sendMessage(ResultUtil.msg(1, "实时消息提醒连接成功").jsonStr());
		} catch (IOException e) {
			logger.info("IO异常");
		}
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		ConcurrentHashMap<String, MyWebSocket> compMap = webSocketMap.get(userInfo.getCompanyCode());
		if (compMap != null) {
			compMap.remove(userInfo.getUserName(), this); // 加入Map中
		}
		subOnlineCount(); // 在线数减1
		logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("来自客户端的消息:" + message);
	}

	/**
	 * 发生错误时调用
	 * 
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		logger.info("发生错误");
		error.printStackTrace();
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}

	/**
	 * 群发自定义消息
	 */
	public static void sendInfo(String message) throws IOException {
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		MyWebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		MyWebSocket.onlineCount--;
	}
}
