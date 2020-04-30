package com.ttil.service;

import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttil.entity.ExamLocationSess;
import com.ttil.repository.ExamLocaRepository;

@Service
public class ExamLocationService {

	@Autowired
	private ExamLocaRepository examLocaRepository;
	
	public void saveData(ExamLocationSess examLocationSess) {
		String start_time = examLocationSess.getStart_time();
		String end_time = examLocationSess.getEnd_time();
		
		String add = start_time + '-' + end_time;
		@SuppressWarnings("resource")
		String session1 = new Formatter().format(add, start_time,end_time).toString(); 
		examLocationSess.setSession_timings(session1);
		examLocaRepository.save(examLocationSess);
	}
	public List<ExamLocationSess> getData() {

		return examLocaRepository.findAll();

	}

	/*
	 * public int getMaxid() {
	 * 
	 * return examLocaRepository.findmaxId();
	 * 
	 * }
	 * 
	 * public String getId() {
	 * 
	 * return examLocaRepository.findId();
	 * 
	 * }
	 * 
	 * public int getHibernateId() {
	 * 
	 * return examLocaRepository.gethibernateSequenceId();
	 * 
	 * }
	 */
	
}
