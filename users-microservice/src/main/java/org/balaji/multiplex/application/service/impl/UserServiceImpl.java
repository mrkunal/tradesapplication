package org.balaji.multiplex.application.service.impl;

import org.balaji.multiplex.application.dao.UsersDao;
import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.application.service.UsersService;
import org.balaji.multiplex.application.utils.co.UserCo;
import org.balaji.multiplex.application.utils.vo.UserVo;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.balaji.multiplex.commons.service.impl.BaseServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**

 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<Users, UserCo, UserVo> implements UsersService {

	private UsersDao usersDao;
	private PasswordEncoder passwordEncoder;

	/**
	 * @param usersDao
	 */
	public UserServiceImpl(UsersDao usersDao, PasswordEncoder passwordEncoder) {
		super(usersDao);
		this.usersDao = usersDao;
		this.passwordEncoder = passwordEncoder;
	}


	/*
	 * @param usersCo
	 * 
	 * @param user
	 * 
	 * @return
	 */
	@Override
	public Users getUserInstance(UserCo usersCo, Users users) {
		users.setRoles(usersCo.getRoles());
		users.setUsername(usersCo.getUsername());
		users.setEmail(usersCo.getEmail());
		users.setFirstName(usersCo.getFirstName());
		users.setLastName(usersCo.getLastName());
		users.setIsActive(usersCo.getIsActive());
		users.setIsDeleted(usersCo.getIsDeleted());
		users.setPassword(passwordEncoder.encode(usersCo.getPassword()));
		return users;
	}

	@Override
	public Users getEntity(UserCo coObject, Users object) {
		if(object==null){
			object=new Users();
		}
		return getUserInstance(coObject,object);
	}

	/*
	 * @return
	 */
	@Override
	public Optional<Users> getCurrentUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof CustomUserDetails) {
			return usersDao.findByUserId(((CustomUserDetails) principal).getUserId());
		}
		return Optional.ofNullable(null);
	}

	@Override
	public List<Users> getUserByName(String fullName) {
		return usersDao.findByfullNameStartsWithIgnoreCase(fullName);
	}

	@Override
	public Optional<Users> getUserByUserId(Integer userId) {
		
		return usersDao.findByUserId(userId);
	}

	@Override
	public Optional<Users> getByUsername(String username) {
		return usersDao.findByUsername(username);
	}

}
