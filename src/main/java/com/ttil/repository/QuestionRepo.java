package com.ttil.repository;

import org.springframework.data.repository.CrudRepository;

import com.ttil.entity.StoringQuestionAndAnswer;

public interface QuestionRepo extends CrudRepository<StoringQuestionAndAnswer, Integer> {

}
