/*
package org.balaji.multiplex.commons.config.mongo;

import org.bson.Document;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

*/
/**

 *
 * @param <T>
 * @param <ID>
 *//*

public class InheritanceAwareSimpleMongoRepository<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> {

	private final MongoOperations mongoOperations;
	private final MongoEntityInformation<T, ID> entityInformation;
	private final Document classCriteriaDocument;
	private final Criteria classCriteria;

	*/
/**
	 * @param metadata
	 * @param mongoOperations
	 *//*

	public InheritanceAwareSimpleMongoRepository(MongoEntityInformation<T, ID> metadata,
                                                 MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.mongoOperations = mongoOperations;
		this.entityInformation = metadata;

		if (entityInformation.getJavaType().isAnnotationPresent(TypeAlias.class)) {
			classCriteria = where("_class").is(entityInformation.getJavaType().getAnnotation(TypeAlias.class).value());
			classCriteriaDocument = classCriteria.getCriteriaObject();
		} else {
			classCriteriaDocument = new Document();
			classCriteria = null;
		}
	}

	*/
/*
	 * @return
	 *//*

	@Override
	public long count() {
		return classCriteria != null
				? mongoOperations.getCollection(entityInformation.getCollectionName()).count(classCriteriaDocument)
				: super.count();
	}

	*/
/*
	 * @return
	 *//*

	@Override
	public List<T> findAll() {
		return classCriteria != null ? mongoOperations.find(new Query().addCriteria(classCriteria),
				entityInformation.getJavaType(), entityInformation.getCollectionName()) : super.findAll();
	}

	*/
/*
	 * @param pageable
	 * @return
	 *//*

	@Override
	public Page<T> findAll(Pageable pageable) {
		return classCriteria != null
				? new PageImpl<T>(mongoOperations.find(
						new Query().addCriteria(classCriteria).limit(pageable.getPageSize()).skip(pageable.getOffset()),
						entityInformation.getJavaType(), entityInformation.getCollectionName()), pageable, count())
				: super.findAll(pageable);
	}

}
*/
