package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;







//≤‚ ‘
@Controller
public class TestSpringMvc {

	@RequestMapping("/SpringMvc")
	public String testSpringMvc(){
		
		System.out.println("testSpringMvc");
		return "test";
	}
}
