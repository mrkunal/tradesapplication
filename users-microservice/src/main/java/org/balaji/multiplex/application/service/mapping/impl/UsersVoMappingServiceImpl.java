package org.balaji.multiplex.application.service.mapping.impl;

import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.application.service.mapping.UsersVoMappingService;
import org.balaji.multiplex.application.utils.vo.UserVo;
import org.springframework.stereotype.Service;

/**

 *
 */
@Service
public class UsersVoMappingServiceImpl implements UsersVoMappingService {

	/*
	 * @param users
	 * 
	 * @return
	 */
	@Override
	public UserVo map(Users users, UserVo usersVo) {
		if (usersVo == null) {
			usersVo = new UserVo();
		}
		//usersVo.setUserId(users.getUserId());
		usersVo.setEmail(users.getEmail());
		usersVo.setFirstName(users.getFirstName());
		usersVo.setLastName(users.getLastName());
		usersVo.setUsername(users.getUsername());
		usersVo.setRoles(users.getRoles());
		usersVo.setPassword(users.getPassword());
		return usersVo;
	}

}
