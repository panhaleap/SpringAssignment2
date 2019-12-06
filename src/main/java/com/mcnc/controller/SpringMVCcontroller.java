package com.mcnc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SpringMVCcontroller {
@RequestMapping("/springmvc")
	public String redirect()
	{
		return "viewpage_spring_mvc";
	}	
}