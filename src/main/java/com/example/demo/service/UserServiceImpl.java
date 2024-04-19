package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		return userRepository.save(user);
	}

	
}
