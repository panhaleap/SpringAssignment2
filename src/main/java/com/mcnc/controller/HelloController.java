package com.mcnc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping("hello")
	public String display(@RequestParam("name")String name, @RequestParam("pwd")String pwd, Model m) {

		if(name.equalsIgnoreCase("admin")) {
			String msg = "Hello "+ name;
			//add a message to the model
			m.addAttribute("message", msg);
			return "viewpage";
		}else {
			String msg = "Sorry "+ name +". You entered an incorrect password";
			return "errorpage";
		}
	}

}
