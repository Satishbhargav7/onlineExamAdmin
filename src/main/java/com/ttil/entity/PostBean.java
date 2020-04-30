package com.ttil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class PostBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int post_id;
	@Column(name="post_name ")
	private String post_name;
	
	@Column(name="post_description ")
	private String post_description;

	@Column(name="post_qualifications")
	private String post_qualifications;
	
	@Column(name="no_of_vacancies")
	private String no_of_vacancies;

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPost_name() {
		return post_name;
	}

	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}

	public String getPost_description() {
		return post_description;
	}

	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}

	public String getPost_qualifications() {
		return post_qualifications;
	}

	public void setPost_qualifications(String post_qualifications) {
		this.post_qualifications = post_qualifications;
	}

	public String getNo_of_vacancies() {
		return no_of_vacancies;
	}

	public void setNo_of_vacancies(String no_of_vacancies) {
		this.no_of_vacancies = no_of_vacancies;
	}
	
	
}
