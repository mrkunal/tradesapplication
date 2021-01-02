package org.balaji.multiplex.commons.dao;

import java.util.Map;
import java.util.Optional;

public interface HashRedisRepository<E> {

	Map<String, E> findAll();

	void put(String key, E entity);

	Optional<E> get(String key);
	
	void delete(String key);
	
}
