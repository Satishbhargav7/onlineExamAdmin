package com.ttil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ttil.entity.ExamBean;

@Repository
public interface ExamRepository extends CrudRepository<ExamBean, Integer> {

	@Override
	List<ExamBean> findAll();

	ExamBean findById(int id);

	@Query(value = "SELECT * FROM exambean", nativeQuery = true)
	List<ExamBean> findExamNames();
}
