package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String start() {
		return "exam03";
	}
	
	@RequestMapping("/input")
	public String input(int num1,int num2,int num3) {
		
		int subTotal = num1+num2+num3;
		int tax = (int)(subTotal*0.1);
		int total = subTotal+tax;
		
		application.setAttribute("subTotal", subTotal);
		application.setAttribute("total", total);
		application.setAttribute("tax", tax);
		
		return "exam03-result";
	}

}
