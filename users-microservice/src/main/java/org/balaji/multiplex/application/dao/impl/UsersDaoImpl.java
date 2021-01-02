package org.balaji.multiplex.application.dao.impl;

import org.balaji.multiplex.application.dao.UsersDao;
import org.balaji.multiplex.application.domain.Users;
import org.balaji.multiplex.application.repositories.UserRepository;
import org.balaji.multiplex.commons.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author KUNAL Kumar
 *
 */
@Service
public class UsersDaoImpl extends BaseDaoImpl<Users> implements UsersDao {

	private UserRepository userRepository;

	/**
	 * @param userRepository
	 */
	public UsersDaoImpl(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	@Override
	public Users findFirstByOrderByUserIdDesc() {
		return userRepository.findFirstByOrderByUserIdDesc();
	}

	@Override
	public Optional<Users> findByUserId(Integer userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public List<Users> findByfullNameStartsWithIgnoreCase(String firstName) {
		return userRepository.findByfirstNameStartsWithIgnoreCase(firstName);
	}

	@Override
	public Optional<Users> findByUsername(String username) {
		System.out.println("###"+ userRepository.findByUsername(username));
		return userRepository.findByUsername(username);
	}

}
