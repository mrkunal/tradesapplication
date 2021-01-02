package org.balaji.multiplex.commons.config;

import org.balaji.multiplex.commons.config.AppConfig;
import org.balaji.multiplex.commons.service.MessagePublisher;
import org.balaji.multiplex.commons.service.MessageSubscriber;
import org.balaji.multiplex.commons.service.impl.MessagePublisherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	private AppConfig appConfig;

	/**
	 * @param appConfig
	 */
	public RedisConfig(AppConfig appConfig) {
		super();
		this.appConfig = appConfig;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
				appConfig.getRedisHost(), appConfig.getPort());
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate() {
		final RedisTemplate<String, String> template = new RedisTemplate<String, String>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setDefaultSerializer(getRedisSerializer());
		return template;
	}

/*	@Bean
	public StringRedisTemplate getStringRedisTemplate() {
		final StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}*/
	
	@Bean
	public StringRedisSerializer getRedisSerializer() {
		return new StringRedisSerializer();
	}

	@Bean
	public MessagePublisher redisPublisher() {
		return new MessagePublisherImpl(redisTemplate(), topic());
	}

	@Bean
	public ChannelTopic topic() {
		return new ChannelTopic("pubsub:queue");
	}

	@Bean
	public MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new MessageSubscriber());
	}
}
