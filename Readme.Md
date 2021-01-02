# users-api

**User-api** is used to manage the users


## Requirements/Dependencies

- Java 11
- Maven ( build tool)
- Spring Boot 2.1.4.RELEASE
- Spring-boot-starter-test
- Spring-data-mongodb
- Spring-boot-starter-security
- Spring-boot-starter-amqp
- Spring-boot-starter-redis
- springfox-swagger2 ( 2.9.2 )
- springfox-swagger-ui ( 2.9.2 )
- lombok
- spring-boot-starter-log4j2
- gson
- commons-api (0.2)
- validation-api
- spring-cloud-starter-openfeign
- spring-boot-starter-mustache
- spring-boot-devtools
- spring-boot-starter-actuator
- spring-cloud-dependencies
- git-commit-id-plugin

## IDE/Tools
Spring tool suite ( >= 4)  
Git bash  
Maven  
Studio 3t/Robo 3t or any other tool for mongodb

## Git Repository


## Mongodb Collections


> **Note :** To setup the monogdb in localhost you need to install mongodb then import/copy the above collections from prod/uat env to localhost.   

## Install

 1. Create a folder.
 2. Clone the repository with below command ( ssh keys to present in git)


 3. cd users-api.
 4. Import the project in STS.
 5. Set the current profile in application.yml file according to env.
 6. Run the application as **spring boot app**

## Swagger

| **Env** | **End Point** |
|---|---|
| **Prod:** | http://ss|
| **UAT:** | http://ss|  
| **QA:** | http://ss|

## Deployment

**users-api** is deployed as a service in cloud foundry. Below are the steps to deploy.

 1. Use **CI-CD** pipeline in gitlab
2. click on run pipeline > select the branch > run pipeline.
3. Then after successful build click on env on which you want to deploy (dev, qa, uat ,prod)

## cloud Foundry
**Routes**  

 | **Env** | **Route** |
 | --- | ------ |
 | **PROD** | [http)|
 

##Setup Steps
>docker run --name balaji-multiplex-redis -d redis

Run MongoDb

>docker run --name balaji-multiplex-mongodb -v C:/Users/kunkumar9/main/data -d -p 27017:27017 mongo


##API's
GET 
POST-update
POST-update
DELETE-
GET list

## Authors

Kunal Kumar