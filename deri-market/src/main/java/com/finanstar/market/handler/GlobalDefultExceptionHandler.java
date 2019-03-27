package com.finanstar.market.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finanstar.domain.Result;
import com.finanstar.util.ResultUtil;

/**
 * @description：
 * 
 * @author:Daniel Pine
 * @email:danielpine@sina.com
 * @date :2018年9月20日-上午10:20:02
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);

	// 声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result<?> defultExcepitonHandler(HttpServletRequest request, Exception e) {
		logger.info("=======================================_↓_Global Exception Handler_↓_=============================================");
		logger.error("Excepiton > ", e);
		logger.info("=======================================_↑_Global Exception Handler_↑_=============================================");
		return ResultUtil.error(0, e.getMessage());
	}

}
