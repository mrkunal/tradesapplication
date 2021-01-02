package org.balaji.multiplex.application.dao;


import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.commons.dao.BaseDao;

import java.util.List;
import java.util.Optional;

public interface UsersDao extends BaseDao<Users> {

	Users findFirstByOrderByUserIdDesc();
	
	Optional<Users> findByUsername(String username);
	
	Optional<Users> findByUserId(Integer userId);
	
	List<Users> findByfullNameStartsWithIgnoreCase(String fullName);
	
	
}
