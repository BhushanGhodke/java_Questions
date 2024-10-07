package com.java.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.questions.dto.QuestionDTO;
import com.java.questions.entity.Questions;
import com.java.questions.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public String getAllQuestion(Model model) {
		List<Questions> allQuestions = questionService.getAllQuestions();
		model.addAttribute("questions", allQuestions);		
		return "home";
	}
	
	@PostMapping("/add")
	public String addQuestions(@ModelAttribute ("entry")Questions questions) {
		String status = questionService.addQuestion(questions);
		return "redirect:/";
	}
	
	@GetMapping("/add")
	public String addQuestion( Model model) {
		model.addAttribute("entry", new Questions());
		return "addQuestion";
	}
	
	@GetMapping("/delete/{questionId}")
	public String deleteQuestions(@PathVariable String questionId, Model model) {
		
		String status = questionService.deleteQuestion(questionId);
	
		model.addAttribute("msg", status);
		
		return "redirect:/";
		
	}
}
