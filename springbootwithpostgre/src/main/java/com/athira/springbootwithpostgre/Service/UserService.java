package com.athira.springbootwithpostgre.Service;

import java.util.List;

import com.athira.springbootwithpostgre.Model.UserEntity;

public interface UserService {

	List<UserEntity> getAllUser();

	UserEntity getUserById(Integer userId);

	void saveUser(UserEntity user);

	void updateUser(UserEntity user, Integer userId);

	void deleteUserById(Integer userId);

}
