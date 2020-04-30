package com.ttil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exambean")
public class ExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="exam_id", unique=true, nullable = false)
	private int id;
	
	@Column(name= "exam_code")
	private String exam_code;
	
	@Column(name="exam_name")
	private String exam_name;
	
	@Column(name="exam_date")
    private String exam_date;
	
	@Column(name="duration")
    private String duration;
	
	@Column(name="marks_per_question")
    private String marks_per_question;
	
	@Column(name="negativemarks_per_question")
    private String negativemarks_per_question;
	
	@Column(name="exam_description")
	private String exam_description;
		
	@Column(name="post_name")
	private String post_name;
	
	public String getPost_name() {
		return post_name;
	}

	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExam_code() {
		return exam_code;
	}

	public void setExam_code(String exam_code) {
		this.exam_code = exam_code;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public String getExam_date() {
		return exam_date;
	}

	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMarks_per_question() {
		return marks_per_question;
	}

	public void setMarks_per_question(String marks_per_question) {
		this.marks_per_question = marks_per_question;
	}

	public String getNegativemarks_per_question() {
		return negativemarks_per_question;
	}

	public void setNegativemarks_per_question(String negativemarks_per_question) {
		this.negativemarks_per_question = negativemarks_per_question;
	}

	public String getExam_description() {
		return exam_description;
	}

	public void setExam_description(String exam_description) {
		this.exam_description = exam_description;
	}

	

}
