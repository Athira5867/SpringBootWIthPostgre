package com.athira.springbootwithpostgre.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.springbootwithpostgre.Model.UserEntity;
import com.athira.springbootwithpostgre.Repository.UserRepository;
import com.athira.springbootwithpostgre.Service.UserService;

@Service

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> getAllUser() {
		//to get all users
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(Integer userId) {
		Optional<UserEntity> userOpt= userRepository.findById(userId);
		if(userOpt.isPresent())
			return userOpt.get();
		else
			throw  new RuntimeException("User not Found");
	}

	@Override
	public void saveUser(UserEntity user) {
		UserEntity userDetail = userRepository.save(user);
		System.out.println("user saved to db with user id :" + userDetail.getId());
		
	}

	@Override
	public void updateUser(UserEntity user, Integer userId) {
		Optional<UserEntity> userDetailOpt = userRepository.findById(userId);
		if(userDetailOpt.isPresent()) {
			UserEntity userDetail = userDetailOpt.get();
			if(user.getName() != null || user.getName().isEmpty())
				userDetail.setName(user.getName());
			if(user.getCity() != null || user.getCity().isEmpty())
				userDetail.setCity(user.getCity());
			if(user.getPwd() != null || user.getPwd().isEmpty())
				userDetail.setPwd(user.getPwd());
		}
		else
			throw  new RuntimeException("User not Found");
		
	}

	@Override
	public void deleteUserById(Integer userId) {
		Optional<UserEntity> userOpt = userRepository.findById(userId);
		if(userOpt.isPresent())
			userRepository.deleteById(userId);
		else
			throw  new RuntimeException("User not Found");
		
	}

}
