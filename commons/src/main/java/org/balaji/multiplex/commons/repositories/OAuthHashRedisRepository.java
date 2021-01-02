package org.balaji.multiplex.commons.repositories;

import org.balaji.multiplex.commons.dao.impl.HashRedisRepositoryImpl;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**

 *
 */
@Service
public class OAuthHashRedisRepository extends HashRedisRepositoryImpl<CustomUserDetails> {

	private static final String BUCKET_NAME = "oauth";

	private RedisTemplate<String, String> redisTemplate;

	/**
	 * @param redisTemplate
	 * @param bucketName
	 * @param redisTemplate2
	 */
	public OAuthHashRedisRepository(RedisTemplate redisTemplate) {
		super(redisTemplate, BUCKET_NAME, CustomUserDetails.class);
		this.redisTemplate = redisTemplate;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Oauth Initialized"+this.getClass());
	}

}
