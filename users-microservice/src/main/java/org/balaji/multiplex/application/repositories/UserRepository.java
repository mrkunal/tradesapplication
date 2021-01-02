package org.balaji.multiplex.application.repositories;

import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.commons.repositories.BaseMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseMongoRepository<Users> {

 	Users findFirstByOrderByUserIdDesc();
 	
 	Optional<Users> findByUserId(Integer userId);
 	
 	Optional<Users> findByUsername(String username);
 	
 	List<Users> findByfirstNameStartsWithIgnoreCase(String firstName);
}
