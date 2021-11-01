package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String start() {
		return "exam02";
	}
	
	@RequestMapping("/calc")
	public String calc(int num1,int num2) {
		int result = num1 + num2;
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", result);
		return "exam02-result";
	}
	
	@RequestMapping("/next")
	public String next() {
		
		return "exam02-result2";
		
	}

}
