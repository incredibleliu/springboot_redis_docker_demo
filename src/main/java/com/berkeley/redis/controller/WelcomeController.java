package com.berkeley.redis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class WelcomeController {
	
	private static Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
    @Autowired 
    private RedisAtomicInteger atomicInteger; 
	
	@RequestMapping("/")
	@ResponseBody	
	public String welcome(Map<String, Object> model, HttpServletResponse response) {
		log.info("enter WelcomeController.welcome...");
		int count = atomicInteger.incrementAndGet(); 
		String result = "<html><body><th><h1>This is the " + count + " visitor</th></h1></body></html>";
		model.put("message", result);
		//return "welcome";
		log.info("WelcomeController.welcome returns {}", result);
		return result;
	}
	
}
