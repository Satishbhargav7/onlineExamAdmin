package com.ttil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int candidate_id;

	@Column(name = "rollno")
	private String rollno;

	@Column(name = "full_name")
	private String full_name;

	@Column(name = "father_name")
	private String father_name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String dob;

	@Column(name = "category")
	private String category;

	@Column(name = "mobile_no")
	private String mobile_no;

	@Column(name = "email_id")
	private String email_id;

	@Column(name = "exam_name")
	private String exam_name;

	@Column(name = "exam_loc_session_id")
	private String exam_loc_session_id;

	@Column(name = "location_name")
	private String location_name;

	@Column(name = "session_timings")
	private String session_timings;
	
	
	public String getSession_timings() {
		return session_timings;
	}

	public void setSession_timings(String session_timings) {
		this.session_timings = session_timings;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public String getExam_loc_session_id() {
		return exam_loc_session_id;
	}

	public void setExam_loc_session_id(String exam_loc_session_id) {
		this.exam_loc_session_id = exam_loc_session_id;
	}

}
