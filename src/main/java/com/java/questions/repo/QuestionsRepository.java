package com.java.questions.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.questions.entity.Questions;

public interface QuestionsRepository extends MongoRepository<Questions, String>{

	public Questions findByQuestion(String question);
}
