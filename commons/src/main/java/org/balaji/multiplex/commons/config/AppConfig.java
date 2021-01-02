package org.balaji.multiplex.commons.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
@Data
public class AppConfig {

	
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private int port;
	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}



/*	@Bean
	public RedisTemplate getRedisTemplate() {
		return new RedisTemplate<>();
	}*/
}
