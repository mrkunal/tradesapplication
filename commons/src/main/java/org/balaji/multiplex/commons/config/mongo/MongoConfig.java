package org.balaji.multiplex.commons.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
/*
    @Bean
    public MongoDbFactory getMongoDbFactory(){
        return new SimpleMongoDbFactory(new MongoClient("localhost",27017),"test");
    }

    @Bean
 public MongoTemplate getMongoTemplate(){
        MongoTemplate mongoTemplate=new MongoTemplate(getMongoDbFactory());
        return mongoTemplate;
 }*/
}
