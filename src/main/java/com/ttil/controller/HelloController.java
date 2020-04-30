package com.ttil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttil.entity.ExamBean;
import com.ttil.entity.LoginBean;
import com.ttil.entity.PostBean;
import com.ttil.service.ExamService;
import com.ttil.service.LoginService;
import com.ttil.service.PostService;

@Controller

public class HelloController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private ExamService examService;
	@Autowired
	private PostService postService;
	

	@RequestMapping("/loginurl")
	public ModelAndView login(@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView mv = new ModelAndView("adminHome");
		ModelAndView m1 = new ModelAndView("index");
		List<LoginBean> record = loginService.getdata(loginBean.getUsername(), loginBean.getPassword());
		if (record.isEmpty() == false) {
			mv.addObject("msg", "valid credentials");
			return mv;
		} else {
			m1.addObject("msg", "Invalid Credentials");
			return m1;
		}

	}
	@RequestMapping("/posturl")
	public String postdata()
	{
		
		return "createPost";
	}
	
	@RequestMapping("/redirectpost")
	public String redirectPost(@ModelAttribute("postBean")PostBean postBean)
	{
		postService.getData(postBean);
		return"createPost";
	}
	
	@RequestMapping("/pindexurl")
	public String redirect1() {
		return "pindex";
	}
	
	@RequestMapping("/createexamurl")
	public String redirect2(Model model) {
		model.addAttribute("value", postService.getPostResult());
		return "createExam";
	}
	@RequestMapping(value = "/examformurl", method = RequestMethod.POST)
	public ModelAndView post(Model model, @ModelAttribute("examBean") ExamBean examBean) {
		//ModelAndView view=redirect2();
		examService.getData(examBean);
		
		model.addAttribute("value", postService.getPostResult());
		ModelAndView m2=new ModelAndView("createExam");
		return m2;
	}
	
	@RequestMapping("/homeurl")
	public String homedata()
	{
		return "adminHome";
	}
	
	@RequestMapping("/examlist")
	public String redirect3(Model model, @ModelAttribute("examBean") ExamBean examBean) {
		model.addAttribute("values", examService.getResult());
		return "examList";
	}
	@RequestMapping("/examedit")
	public String redirect4(Model model) {
		model.addAttribute("values",examService.getResult());
		return "examEdit";
	}
	@RequestMapping("/editurl/{id}")
	public String redirect3(Model model,@PathVariable("id") int givenID) {
		System.out.println("method working");
		
		model.addAttribute("updateValues", examService.getDataForUpdate(givenID));
		model.addAttribute("value",postService.getPostResult());
		return "updateExam";
	}

	@RequestMapping("/examupdateurl/{id}")
	public String redirect5(Model model, @PathVariable("id") int givenID,
			@ModelAttribute("examBean") ExamBean examBean) {
		examBean.setId(givenID);
		examService.getData(examBean);
		// Show All data
		model.addAttribute("values",examService.getResult());
		return "examList";

	}
	@RequestMapping("deleteurl/{id}")
	public String redirect6(Model model, @PathVariable("id") int givenID,
			@ModelAttribute("examBean") ExamBean examBean) {

		examService.deleteByid(givenID);
		model.addAttribute("values", examService.getResult());
		return "examList";
	}
	
	
}
