package com.java.questions.service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.questions.entity.Questions;
import com.java.questions.repo.QuestionsRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionsRepository questionRepository;
	
	public String addQuestion(Questions questions) {
		
	questionRepository.save(questions);
	
		return "Question record successfully";
	}
	
	
	public List<Questions> getAllQuestions(){
		
		List<Questions> questions = questionRepository.findAll();
	
		return questions;
	}
	
	
	public String deleteQuestion(Integer questionId) {
	
		questionRepository.deleteById(questionId);
		return "deleted";
		
	}
	
	
	public Questions getQuestionById(Integer questionId) {
		
		Questions question=questionRepository.findById(questionId).orElseThrow();
	
		return question;
	}

	
	public Boolean updateQuestionById(Questions question) {
		
		Questions quest=questionRepository.findById(question.getQuestionId()).orElseThrow();
	
		BeanUtils.copyProperties(question, quest);
	
		 Questions save = questionRepository.save(quest);
		return save.getQuestionId()!=null;
	}

}
