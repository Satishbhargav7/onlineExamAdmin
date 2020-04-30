package com.ttil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "examlocation")
public class ExamLocationSess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_loc_session_id")
	private int exam_loc_session_id;


	public int getExam_loc_session_id() {
		return exam_loc_session_id;
	}

	public void setExam_loc_session_id(int exam_loc_session_id) {
		this.exam_loc_session_id = exam_loc_session_id;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "location_name")
	private String location_name;

	@Column(name = "address")
	private String address;

	@Column(name = "session_timings")
	private String session_timings;
	@Transient
	private String start_time;

	@Transient
	private String end_time;

	public String getSession_timings() {
		return session_timings;
	}

	public void setSession_timings(String session_timings) {
		this.session_timings = session_timings;
	}

	@Column(name = "examdate")
	private String examdate;

	@Column(name = "session_date_time")
	private String date_created;
	
	@Column(name = "examId")
	private String id;

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getExamdate() {
		return examdate;
	}

	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}

}
