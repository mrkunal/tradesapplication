/*
package org.balaji.multiplex.commons.config.mongo;

import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.data.mongodb.repository.query.MongoQueryMethod;
import org.springframework.data.mongodb.repository.query.StringBasedMongoQuery;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.QueryMethodEvaluationContextProvider;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;

//import org.springframework.data.repository.query.EvaluationContextProvider;

//QueryMethodEvaluationContextProvider

*/
/**

 *
 *//*

public class MongoQueryLookupStrategy implements QueryLookupStrategy {

    private static final SpelExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();

   
	private final MongoOperations operations;
	private final QueryMethodEvaluationContextProvider evaluationContextProvider;
	MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext;

	*/
/**
	 * @param operations
	 * @param evaluationContextProvider
	 * @param mappingContext
	 *//*

	public MongoQueryLookupStrategy(MongoOperations operations, QueryMethodEvaluationContextProvider evaluationContextProvider,
                                    MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {

		this.operations = operations;
		this.evaluationContextProvider = evaluationContextProvider;
		this.mappingContext = mappingContext;
	}

	*/
/*
	 * @param method
	 * @param metadata
	 * @param factory
	 * @param namedQueries
	 * @return
	 *//*

	public RepositoryQuery resolveQuery(Method method, RepositoryMetadata metadata, ProjectionFactory factory,
                                        NamedQueries namedQueries) {
	

			MongoQueryMethod queryMethod = new MongoQueryMethod(method, metadata, factory, mappingContext);
			String namedQueryName = queryMethod.getNamedQueryName();

			if (namedQueries.hasQuery(namedQueryName)) {
				String namedQuery = namedQueries.getQuery(namedQueryName);
				return new StringBasedMongoQuery(namedQuery, queryMethod, operations, EXPRESSION_PARSER,
						evaluationContextProvider);
			} else if (queryMethod.hasAnnotatedQuery()) {
				return new StringBasedMongoQuery(queryMethod, operations, EXPRESSION_PARSER, evaluationContextProvider);
			} else {
				return new InheritanceAwarePartTreeMongoQuery(queryMethod, operations);
			}
	}

	
	
	
}
*/
