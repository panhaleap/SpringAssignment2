package com.mcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
		    
    @GetMapping("/")
    public String index(Model model) {

       model.addAttribute("message", "Hello Spring MVC 5!");
       return "hello";
   }
    
    @GetMapping("/upload")
    public String getPageUpload(Model model) {
       return "upload";
   }
    
   @GetMapping("/ckEditor")
   public String getPageCKeditor(Model model) {
	return "ckEditor";
}
}

