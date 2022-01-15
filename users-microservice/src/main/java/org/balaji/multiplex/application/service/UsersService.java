package org.balaji.multiplex.application.service;

import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.application.utils.co.UserCo;
import org.balaji.multiplex.application.utils.vo.UserVo;
import org.balaji.multiplex.commons.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface UsersService extends BaseService<Users, UserCo, UserVo> {

	Users getUserInstance(UserCo coObject, Users tradesUsers);
	
	Optional<Users> getCurrentUser();

	List<Users> getUserByName(String name);
	
	Optional<Users> getUserByUserId(Integer userId);
	
	Optional<Users> getByUsername(String username);

}
