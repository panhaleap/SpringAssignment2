package com.mcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootController {
	@RequestMapping("springboot")
	public String display() {
		return "viewpage_spring_boot";
	}
}
