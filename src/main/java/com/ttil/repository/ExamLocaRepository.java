package com.ttil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ttil.entity.ExamLocationSess;
import com.ttil.service.ExamLocationService;

@Repository
public interface ExamLocaRepository extends CrudRepository<ExamLocationSess, Integer>{

	void save(ExamLocationService locationService);

	@Override
	List<ExamLocationSess> findAll();
	
	public static final String FIND_maxId = "SELECT MAX(id) FROM new.examlocation";

	
	  @Query(value = FIND_maxId, nativeQuery = true) 
	  public int findmaxId();
	 
	
	public static final String FIND_Id = "SELECT * FROM new.examlocation limit 1";
	
	@Query(value = FIND_Id, nativeQuery = true)
	public String findId();
	
	public static final String FINDhibernate_Id = "SELECT * FROM new.hibernate_sequence";
	@Query(value= FINDhibernate_Id, nativeQuery = true)
	public int gethibernateSequenceId();

	
	
	

	
}
