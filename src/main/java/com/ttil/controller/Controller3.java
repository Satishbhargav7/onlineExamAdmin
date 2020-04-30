package com.ttil.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ttil.entity.ExamBean;
import com.ttil.entity.StoringQuestionAndAnswer;
import com.ttil.service.QuestionService;

@Controller

public class Controller3 {

	@Autowired
	QuestionService questionService;
		
	  @RequestMapping("/addQuestionUrl") 
	  public String questiondata()
	  {
		  return "qindex";
		 }
	 
	@RequestMapping("/createQuestion")
	public String addQuestionUrl(Model model) {
		List<ExamBean> examList = questionService.findExamNames();
		model.addAttribute("values", examList);
		return "AddQuestion";
	}

	@RequestMapping("/savingQuestionUrl")
	public String savingQuestion(@ModelAttribute StoringQuestionAndAnswer storingQuestionAndAnswer, Model model) {
		questionService.save(storingQuestionAndAnswer);
		return "adminHome";

	}

	@RequestMapping("/uploadQuestion")
	public String uplaodQuestionPaper(Model model) {
		List<ExamBean> examList = questionService.findExamNames();
		model.addAttribute("values", examList);
		return "questionpaperUpload";
	}

	@RequestMapping("/uplaodQuestionUrl")
	public String uplaodQuestionUrl(@RequestParam("file") MultipartFile file, @RequestParam("examName") String examName,
			@RequestParam("setNo") String setNo) {

		try {
			questionService.saveQuestions(file, examName, setNo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "adminHome";
	}
	
}
