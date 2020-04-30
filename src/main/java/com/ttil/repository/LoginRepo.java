package com.ttil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ttil.entity.LoginBean;

public interface LoginRepo extends CrudRepository<LoginBean,Integer> 
{

	@Override
    List<LoginBean> findAll();
	
	List<LoginBean>findByUsernameAndPassword(String username,String password);
}
