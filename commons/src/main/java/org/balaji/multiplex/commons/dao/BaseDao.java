package org.balaji.multiplex.commons.dao;

import org.bson.types.ObjectId;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends BaseEntity> {
	Optional<T> findById(ObjectId objectId);

	Optional<T> findByLastUpdatedDate(Date lastUpdatedDate);

	Optional<T> findByCreatedDate(Date createdDate);

	List<T> findAllByCreatedBy(String userId);

	List<T> findAllByLastUpdatedBy(String userId);

	List<T> findAll();

	Page<T> findAll(Pageable pageable);
	
	Optional<T> save(T t);
	
}
