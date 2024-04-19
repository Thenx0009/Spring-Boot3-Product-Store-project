package com.example.demo.service;

import com.example.demo.entity.UserDto;
import com.example.demo.model.User;

public interface UserService {

	User findByUsername(String username);
	User save(UserDto userDto);
}
