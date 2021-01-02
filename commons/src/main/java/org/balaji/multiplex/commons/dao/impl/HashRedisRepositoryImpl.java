package org.balaji.multiplex.commons.dao.impl;

import com.google.gson.Gson;
import org.balaji.multiplex.commons.dao.HashRedisRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Optional;

public abstract class HashRedisRepositoryImpl<E> implements HashRedisRepository<E> {

	private String BUCKET_NAME;
	private RedisTemplate<String, String> redisTemplate;
	protected HashOperations<String, String, String> hashOperations;
	private Class<E> type;

	private Gson gson = new Gson();

	/**
	 * @param stringRedisTemplate
	 * @param hashOperations
	 */
	public HashRedisRepositoryImpl(RedisTemplate<String, String> redisTemplate, String bucketName, Class<E> type) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
		this.BUCKET_NAME = bucketName;
		this.type = type;
	}

	@Override
	public Map<String, E> findAll() {
		hashOperations.entries(BUCKET_NAME);

		return null;
	}

	@Override
	public void put(String key, E entity) {

		String jsonData = gson.toJson(entity);
		hashOperations.put(BUCKET_NAME, key, jsonData);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<E> get(String key) {
		Optional<String> value = Optional.of(hashOperations.get(BUCKET_NAME, key));
		if (value.isPresent()) {
			E object = (E) gson.fromJson(value.get(), type);
			return Optional.of(object);
		}

		return Optional.of(null);
	}

	@Override
	public void delete(String key) {
		hashOperations.delete(BUCKET_NAME, key);
	}

}
