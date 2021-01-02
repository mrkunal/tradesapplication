/*
package org.balaji.multiplex.commons.config.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {
		"org.balaji.multiplex.*.*" }, repositoryBaseClass = InheritanceAwareSimpleMongoRepository.class, repositoryFactoryBeanClass = InheritanceAwareMongoRepositoryFactoryBean.class)
public class MongoConfigurer {

	*/
/*@Autowired
	private MongoDbFactory mongoDbFactory;
	
	@Autowired
	private MongoTemplate mongoTemplate;*//*


*/
/*	private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
*//*

	*/
/*@PostConstruct
	public MongoTemplate getMongoTemplate() {
		MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
		mongoMapping.setCustomConversions(customConversions()); // tell mongodb to use the custom converters
		mongoMapping.afterPropertiesSet();
		return mongoTemplate;
	}*//*


	*/
/*@Bean
	public MongoCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
		converters.add(new StringToLocalDateTimeConverter());
		converters.add(new LocalDateTimeToStringConverter());
		return new MongoCustomConversions(converters);
	}*//*


}
*/
