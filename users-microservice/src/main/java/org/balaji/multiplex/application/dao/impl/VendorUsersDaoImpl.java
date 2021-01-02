/*
package org.balaji.multiplex.application.dao.impl;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorUsersDaoImpl extends BaseDaoImpl<VendorUsers> implements VendorUsersDao {

	private VendorUsersRepository vendorUsersRepository;

	public VendorUsersDaoImpl(VendorUsersRepository vendorUsersRepository) {
		super(vendorUsersRepository);
		this.vendorUsersRepository = vendorUsersRepository;
	}

	@Override
	public Optional<VendorUsers> findByUsername(String username) {
		
		return vendorUsersRepository.findByUsername(username);
	}
	@Override
	public Optional<VendorUsers> findByUserId(Integer userId) {
		return vendorUsersRepository.findByUserId(userId);
	}

}
*/
