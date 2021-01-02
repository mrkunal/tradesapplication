package org.balaji.multiplex.commons.repositories;

import org.bson.types.ObjectId;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BaseMongoRepository<T extends BaseEntity> extends MongoRepository<T,ObjectId>  {

    Optional<T> findById(ObjectId objectId);
	
	Optional<T> findByLastUpdatedDate(Date lastUpdatedDate);
	
	Optional<T> findByCreatedDate(Date createdDate);
	
	List<T> findAllByCreatedBy(String userId);
	
	List<T> findAllByLastUpdatedBy(String userId);
	
}
