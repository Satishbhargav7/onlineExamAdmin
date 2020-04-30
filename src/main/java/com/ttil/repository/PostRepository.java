package com.ttil.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ttil.entity.PostBean;

@Repository

public interface PostRepository extends CrudRepository<PostBean, Integer>{

}
