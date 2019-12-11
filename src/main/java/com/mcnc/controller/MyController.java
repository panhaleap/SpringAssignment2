package com.mcnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
		
//    @GetMapping({"/", "/hello"})
//    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }
    
    @GetMapping("/")
    public String index(Model model) {

       model.addAttribute("message", "Hello Spring MVC 5!");
       return "hello";
   }
}

