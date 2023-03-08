package com.example.msaservicecoffeemember.domain.repository;



import com.example.msaservicecoffeemember.domain.entity.UserEntity;

import java.util.List;

public interface IUserRepository {
	long getAllUserCount();
	List<UserEntity> getAllUser(String page, String size, String sort, String sortKey);
	UserEntity getUserById(UserEntity userEntity);
	UserEntity addUser(UserEntity userEntity);
	UserEntity modifyUser(UserEntity userEntity);
	void removeUser(List<UserEntity> userEntity);
}
