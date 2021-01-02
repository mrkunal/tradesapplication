package org.balaji.multiplex.commons.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.dao.BaseDao;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.repositories.BaseMongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	private static final Logger log = LogManager.getLogger(BaseDaoImpl.class);

	private BaseMongoRepository<T> baseMongoRepository;

	public BaseDaoImpl(BaseMongoRepository<T> baseMongoRepository) {
		super();
		this.baseMongoRepository = baseMongoRepository;
	}

	@Override
	public Optional<T> findById(ObjectId objectId) {

		return baseMongoRepository.findById(objectId);

	}


	@Override
	public List<T> findAllByCreatedBy(String userId) {

		return baseMongoRepository.findAllByCreatedBy(userId);
	}

	@Override
	public List<T> findAllByLastUpdatedBy(String userId) {
		return baseMongoRepository.findAllByLastUpdatedBy(userId);

	}

	@Override
	public List<T> findAll() {

		return baseMongoRepository.findAll();

	}

	@Override
	public Page<T> findAll(Pageable pageable) {

		return baseMongoRepository.findAll(pageable);
	}

	@Override
	public Optional<T> save(T t) {
		if (t.isNew()) {
			log.trace("object is persisting for the first time : {}", t);
		} else {
			log.trace("object is updating : {}", t);
		}
		t = baseMongoRepository.save(t);
		return Optional.of(t);
	}
	
	/*@Override
	public Optional<T> saveWithAdmin(T t)
	{

		return null;	
	}*/

	@Override
	public Optional<T> findByLastUpdatedDate(Date lastUpdatedDate) {
		return Optional.empty();
	}

	@Override
	public Optional<T> findByCreatedDate(Date createdDate) {
		return Optional.empty();
	}
}
