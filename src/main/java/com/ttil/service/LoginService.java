package com.ttil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttil.entity.LoginBean;
import com.ttil.repository.LoginRepo;

@Service
public class LoginService {
	@Autowired
	LoginRepo loginRepository;

	public void insert(LoginBean login) {
		// TODO Auto-generated method
		loginRepository.save(login);

	}

	public List<LoginBean> get() {
		return (List<LoginBean>) loginRepository.findAll();
	}

	public List<LoginBean> getdata(String username, String password) {
		return loginRepository.findByUsernameAndPassword(username, password);
	}

}

