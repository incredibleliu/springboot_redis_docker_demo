package com.berkeley.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;

@Configuration
@SpringBootApplication
public class RedisApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RedisApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
	
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate() {
//	    RedisTemplate<String, Object> template = new RedisTemplate<>();
//	    template.setConnectionFactory(jedisConnectionFactory());
//	    return template;
//	}
//	
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//	    JedisConnectionFactory jedisConFactory
//	      = new JedisConnectionFactory();
//	    jedisConFactory.setHostName("172.28.1.2");
////	    jedisConFactory.setHostName("localhost");
//	    jedisConFactory.setPort(6379);
//	    return jedisConFactory;
//	}
	
	@Bean 
	public RedisAtomicInteger init(RedisConnectionFactory factory) { 
	    return new RedisAtomicInteger("atomic-counter", factory); 
	} 

}
