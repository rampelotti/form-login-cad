package com.simple_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple_form.model.UsersModel;
import com.simple_form.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public UsersModel registerUser(String login, String password, String email) {
		
		if(login == null || password == null) {
			return null;
		} else {
			if(usersRepository.findFirstByLogin(login).isPresent()){
				System.out.println("Login Duplicado!");
				return null;
			}
			UsersModel usersModel = new UsersModel();
			usersModel.setLogin(login);
			usersModel.setPassword(password);
			usersModel.setEmail(email);
			return usersRepository.save(usersModel);
		}
	}
	
	public UsersModel authenticate(String login,String password) {
		return usersRepository.findByLoginAndPassword(login, password).orElse(null);
	}
}
