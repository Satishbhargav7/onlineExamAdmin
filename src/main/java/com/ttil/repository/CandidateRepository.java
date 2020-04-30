package com.ttil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ttil.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	
	
	
	@Query("SELECT u from Candidate u where u.exam_name=?1 And u.location_name=?2 And u.session_timings=?3")
	List<Candidate> find(String exam_name,String location_name,String session_timings);
	
	
	
	@Query("SELECT n from Candidate n where n.exam_name=?1 And n.location_name=?2 And n.session_timings=?3")
	List<Candidate> findByExam_nameAndLocation_nameAndSession_timings(String exam_name, String location_name,
			String session_timings);

	
	
	 

}
