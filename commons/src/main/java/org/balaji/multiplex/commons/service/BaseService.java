package org.balaji.multiplex.commons.service;

import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.util.vo.BaseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, CO, VO extends BaseVo> {

	Optional<T> get(String id);


	Optional<T> save(T t);

	T getEntity(CO coObject,T object);

	Optional<T> insert(T object);

	Optional<T> create(CO coObject);

	Optional<T> update(CO coObject, T object);

//	Optional<T> delete(String id);

	List<T> findAll();

	Page<T> findAll(Pageable pageable);



}
