package com.sellingperfume.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.repositories.IRepositories;
import com.sellingperfume.services.IUserService;

@Service
public class UserServiceImplements implements IUserService {
	@Autowired
	private IRepositories iRepositories;

	@Override
	public List<UserEntity> GetAllUser() {
		// TODO Auto-generated method stub
		List<UserEntity> listUser = iRepositories.findAll();
		return listUser;
	}

	@Override
	public UserEntity CreateUser(UserEntity user) {
		return iRepositories.save(user);
	}

	@Override
	public UserEntity UpdateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return iRepositories.save(user);
	}

	@Override
	public Optional<UserEntity> findUserById(int id) {
		// TODO Auto-generated method stub
		Optional<UserEntity> user = iRepositories.findById(id);

		return user;
	}

	@Override
	public String GenarateSerectKey() {
		// TODO Auto-generated method stub
		String serectKey = RandomStringUtils.randomAlphabetic(10);
		return serectKey;
	}



}
