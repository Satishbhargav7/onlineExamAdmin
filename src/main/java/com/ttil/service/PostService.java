package com.ttil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttil.entity.PostBean;
import com.ttil.repository.PostRepository;

@Service

public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public void getData(PostBean postBean)
	{
	postRepository.save(postBean);
	}
	
	public List<PostBean> getPostResult()
	{
		return  (List<PostBean>) postRepository.findAll();
	}
}
