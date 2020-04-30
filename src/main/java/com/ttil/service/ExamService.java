package com.ttil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttil.entity.ExamBean;
import com.ttil.repository.ExamRepository;

@Service

public class ExamService {
	@Autowired
	private ExamRepository examRepository;

	public void getData(ExamBean examBean)
	{
		examRepository.save(examBean);
	}
	
	public List<ExamBean>getResult()
	{
		return  examRepository.findAll();
	}
	
public ExamBean getDataForUpdate(int id) {
		
		return examRepository.findById(id);
	}
	
	public void deleteByid(int id) {
		
		examRepository.deleteById(id);
	}
	 
	
}
