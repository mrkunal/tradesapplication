package org.balaji.multiplex.commons.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.balaji.multiplex.commons.dao.BaseDao;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.service.BaseService;
import org.balaji.multiplex.commons.util.vo.BaseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity, CO, VO extends BaseVo> implements BaseService<T, CO, VO> {

	private BaseDao<T> dao;
	protected final Logger log;

	public BaseServiceImpl(BaseDao dao) {
		super();
		this.dao = dao;
		this.log = LogManager.getLogger(this.getClass());
	}

	@Override
	public Optional<T> get(String id) {
		log.trace("BaseService fetching from Id {}", id);
		ObjectId objectId = new ObjectId(id);
		return dao.findById(objectId);
	}

	@Override
	public Optional<T> save(T t) {
		return dao.save(t);
	}

	@Override
	public List<T> findAll() {
		log.trace("BaseService fetching all");
		return dao.findAll();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Optional<T> create(CO coObject) {
		T entity = getEntity(coObject,null);
		return insert(entity);
	}

	@Override
	public Optional<T> update(CO coObject, T object) {
		T entity = getEntity(coObject,object);
		return insert(entity);
	}

	@Override
	public Optional<T> insert(T object) {
		return dao.save(object);
	}
}
