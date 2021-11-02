package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	@ModelAttribute
	public UserForm setUpForm() {
		
		UserForm userForm = new UserForm();
		return userForm;
	}
	
	@RequestMapping("")
	public String start() {
		
		return "exam04";
		
	}
	
	@RequestMapping("/input")
	public String input(
			@Validated UserForm userForm,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return start();
		}
		User user = new User();
		user.setName(userForm.getName());
		user.setAge(Integer.parseInt(userForm.getAge()));
		user.setComment(userForm.getComment());
		
		redirectAttributes.addFlashAttribute("user",user);
		return "redirect:/exam04/result";
		
	}
	
	@RequestMapping("/result")
	public String result() {
		
		return "exam04-result";
		
	}

}
